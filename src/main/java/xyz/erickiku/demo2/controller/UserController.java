package xyz.erickiku.demo2.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.erickiku.demo2.mapper.UserMapper;
import xyz.erickiku.demo2.pojo.User;
import xyz.erickiku.demo2.utils.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    //注册接口
    @GetMapping("/api/register")
    public String register(User user){
        int i = userMapper.insert(user);
        if (i > 0){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("/api/login")
    public String login(String userAccount, String userPassword){
        //获取对应账号的信息
        User user = userMapper.queryUserByAccount(userAccount);
        //如果没有该用户，则返回账号错误
        if (user==null){
            return "AccountError";
        }else{
            //根据账号查询的数据和密码对比，如果都正确，则返回一个token，这里先不处理token
            String pwd = user.getUserPassword();
            if (pwd.equals(userPassword)){
                return "token";
            }else{
                return "PasswordError";
            }
        }
    }
    //登录并且签发token
    @GetMapping("/api/getToken")
    public Map<String,String> token(String userAccount, String userPassword){  //传入的账号密码

        Map<String,String> map=new HashMap<String,String>();
        User user = userMapper.queryUserByAccount(userAccount);
        if (user==null){
            map.put("static","accountError");
            return map;
        }
        if (!userPassword.equals(user.getUserPassword())){
            map.put("static","passwordError");
            return map;
        }
        if(userAccount.equals(user.getUserAccount())&&userPassword.equals(user.getUserPassword())) {  //通过登录验证
            Map<String,String> mapJwt=new HashMap<String,String>();  //传入工具类的参数
            mapJwt.put("name",userAccount);
            String token= JwtUtil.InserToken(mapJwt);  //拿到生成的token
            map.put("static", "successPutToken");
            map.put("tokenvalue", token);
        }else {
            map.put("static", "登录失败！签发token失败");
        }

        return map;
    }
    //验证token
    /**
     *
     * 访问网站普通接口操作 验证用户token
     * @param token
     * @return
     */
    @GetMapping("/api/tokenCheckout")
    public Map<String,String> tokenCheckout(String token){  //传入用户唯一token
        Map<String,String> map=new HashMap<String,String>();
        try {

            DecodedJWT de= JwtUtil.SelectToken(token);
            map.put("static", "tokenSuccess");
            System.out.println("没问题");
            return map;
        } catch (SignatureVerificationException e) {
            System.out.println("第一个问题");
            e.printStackTrace();
        } catch (TokenExpiredException e) {

            e.printStackTrace();
            map.put("static","timeout");
            return map;
        } catch (AlgorithmMismatchException e) {
            System.out.println("第三个问题");
            e.printStackTrace();
        } catch (Exception  e) {
            System.out.println("第四个问题");
            e.printStackTrace();
        }
        System.out.println("结束了");
        return map;
    }
    //查询账号是否存在
    @GetMapping("/api/findAccount")
    public String findAccount(String userAccount){
        User user = userMapper.queryUserByAccount(userAccount);
        if (user!=null){
            return "have";
        }else{
            return "havent";
        }
    }


    @GetMapping("/api/getUserByUserAccount")
    public User getUserByUserAccount(String userAccount){
        User user = userMapper.queryUserByAccount(userAccount);
        if (user == null){
            return null;
        }
        return user;
    }
}
