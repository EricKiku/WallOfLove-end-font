package xyz.erickiku.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.erickiku.demo2.mapper.CommentMapper;
import xyz.erickiku.demo2.mapper.PostMapper;
import xyz.erickiku.demo2.mapper.UserMapper;
import xyz.erickiku.demo2.pojo.Comment;

import java.util.List;

@RestController
public class CommentController {


    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;

    //获取帖子评论
    @GetMapping("/api/getComment")
    public List<Comment> getComment(int postId){
        List<Comment> commentList = commentMapper.selectCommentByPostId(postId);

        return commentList;
    }
}
