package xyz.erickiku.demo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.erickiku.demo2.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE user_account = #{userAccount}")
    User queryUserByAccount(String userAccount);
}
