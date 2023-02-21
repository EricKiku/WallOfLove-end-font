package xyz.erickiku.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.erickiku.demo2.pojo.Post;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<Post> {
    @Select("SELECT * FROM post")
    List<Post> selectAllPost();

    //根据帖子id获取帖子
    @Select("SELECT * FROM post WHERE post_id = #{postId}")
    Post selectPostByPostId(int postId);



    //给帖子增加评论接口
    @Select("INSERT INTO comment(user_id,post_id,comment_date,comment_content,comment_reply)VALUES(#{userId},#{postId},#{date},#{commentContent},#{reply})")
    int putComment(int userId,int postId,String date,String commentContent,int reply);

    //根据用户id获取帖子
    @Select("SELECT * FROM post WHERE user_id = #{userId}")
    List<Post> queryPostByUserId(int userId);
}
