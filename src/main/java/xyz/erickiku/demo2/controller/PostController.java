package xyz.erickiku.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.erickiku.demo2.mapper.CommentMapper;
import xyz.erickiku.demo2.mapper.PostMapper;
import xyz.erickiku.demo2.mapper.UserMapper;
import xyz.erickiku.demo2.pojo.Comment;
import xyz.erickiku.demo2.pojo.Post;
import xyz.erickiku.demo2.pojo.User;

import java.util.List;

import static net.sf.jsqlparser.parser.feature.Feature.comment;

@RestController
public class PostController {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    //获取所有帖子
    @GetMapping("/api/queryAllPost")
    public List<Post> queryAllPost(){
        List<Post> posts = postMapper.selectAllPost();
        return posts;
    }

    //根据帖子iD获取帖子
    @GetMapping("/api/queryPostByPostId")
    public Post queryPostByPostId(int postId){
        Post post = postMapper.selectPostByPostId(postId);
        //获取的同时，也增加该帖子的浏览量
        post.setPostReadcount(post.getPostReadcount()+1);
        postMapper.updateById(post);
        return post;
    }

    //发墙接口
    @GetMapping("/api/putPost")
    public String putPost(String userAccount,String postMessage,String postDate){
        User user = userMapper.queryUserByAccount(userAccount);
        if (user==null){
            return "accountError";
        }else{
            Post post = new Post();
            post.setUserId(user.getUserId());
            post.setPostNick(user.getUserNick());
            post.setPostDate(postDate);
            post.setPostContent(postMessage);
            int insert = postMapper.insert(post);
            if (insert > 0){
                return "success";
            }else{
                return "error";
            }
        }
    }

    //添加评论接口
    @GetMapping("/api/putPostComment")
    public String putPostComment(String userAccount,String commentContent,int postId,String date,int replyPostId){
        User user = userMapper.queryUserByAccount(userAccount);
        if (user == null){
            return "fail";
        }
        Comment comment = new Comment();
        comment.setUserId(user.getUserId());
        comment.setCommentContent(commentContent);
        comment.setPostId(postId);
        comment.setCommentDate(date);
        comment.setCommentReply(replyPostId);
        System.out.println(comment);
        int insert = commentMapper.insert(comment);
        return "success";
    }

    //根据用户id查询帖子
    @GetMapping("/api/queryPostByUserId")
    public List<Post> queryPostByUserId(int userId){
        List<Post> list = postMapper.queryPostByUserId(userId);

        return list;
    }

    //评论的时候调用，增加一个评论
    @GetMapping("/api/addComment")
    public void addComment(int postId){
        Post post = postMapper.selectPostByPostId(postId);
        post.setPostComment(post.getPostComment()+1);
        postMapper.updateById(post);
    }

    //点赞，两个工作：1.给帖子的点赞加1,2.在自己用户的点赞字段中追加帖子id
    @GetMapping("/api/like")
    public User addLike(int postId,int userId){
        //给post的点赞加1
        Post post = postMapper.selectById(postId);
        post.setPostLike(post.getPostLike()+1);
        postMapper.updateById(post);
        //给用户的点赞字段
        User user = userMapper.selectById(userId);
        user.setUserLike(user.getUserLike()+""+postId+",");
        userMapper.updateById(user);
        return user;
    }
}
