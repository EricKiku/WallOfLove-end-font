package xyz.erickiku.demo2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class User{
    /*
    * id,nick,account,password 非空
    * */
    @TableId(type = IdType.AUTO)
    private int userId;
    private String userAccount;
    private String userNick;
    private String userPassword;
    private String userAge;
    private String userSex;
    private String userSelfinfo;
    private String userLike;



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserSelfinfo() {
        return userSelfinfo;
    }

    public void setUserSelfinfo(String userSelfinfo) {
        this.userSelfinfo = userSelfinfo;
    }

    public String getUserLike() {
        return userLike;
    }

    public void setUserLike(String userLike) {
        this.userLike = userLike;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userSelfinfo='" + userSelfinfo + '\'' +
                ", userLike='" + userLike + '\'' +
                '}';
    }
}
