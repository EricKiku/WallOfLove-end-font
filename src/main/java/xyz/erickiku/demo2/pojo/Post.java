package xyz.erickiku.demo2.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Post {
    @TableId(type = IdType.AUTO)
    //非空
    private int postId;
    //非空
    private int userId;
    //非空
    private String postNick;
    //非空
    private String postDate;
    //非空
    private int postReadcount;
    private String postContent;
    private String postPicture;
    //非空
    private int postLike;
    private int postComment;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", postNick='" + postNick + '\'' +
                ", postDate='" + postDate + '\'' +
                ", postReadcount=" + postReadcount +
                ", postContent='" + postContent + '\'' +
                ", postPicture='" + postPicture + '\'' +
                ", postLike=" + postLike +
                ", postComment='" + postComment + '\'' +
                '}';
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostNick() {
        return postNick;
    }

    public void setPostNick(String postNick) {
        this.postNick = postNick;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public int getPostReadcount() {
        return postReadcount;
    }

    public void setPostReadcount(int postReadcount) {
        this.postReadcount = postReadcount;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostPicture() {
        return postPicture;
    }

    public void setPostPicture(String postPicture) {
        this.postPicture = postPicture;
    }

    public int getPostLike() {
        return postLike;
    }

    public void setPostLike(int postLike) {
        this.postLike = postLike;
    }

    public int getPostComment() {
        return postComment;
    }

    public void setPostComment(int postComment) {
        this.postComment = postComment;
    }
}
