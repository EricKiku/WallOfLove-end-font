package xyz.erickiku.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.erickiku.demo2.pojo.Comment;
import xyz.erickiku.demo2.pojo.Post;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    //查询对应帖子id的评论
    @Select("SELECT * FROM comment,user WHERE post_id = #{postId} AND comment.`user_id` = user.`user_id`")
    List<Comment> selectCommentByPostId(int postId);


}
