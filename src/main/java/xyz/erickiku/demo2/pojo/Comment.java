package xyz.erickiku.demo2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Comment {
    private int commentId;
    private int postId;
    private int userId;
    private String commentDate;
    private String commentContent;
    private int commentLike;
    private int commentReply;

    private String userAccount;
    private String userNick;

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

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", commentDate='" + commentDate + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentLike=" + commentLike +
                ", commentReply=" + commentReply +
                ", userAccount='" + userAccount + '\'' +
                ", userNick='" + userNick + '\'' +
                '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(int commentLike) {
        this.commentLike = commentLike;
    }

    public int getCommentReply() {
        return commentReply;
    }

    public void setCommentReply(int commentReply) {
        this.commentReply = commentReply;
    }
}
