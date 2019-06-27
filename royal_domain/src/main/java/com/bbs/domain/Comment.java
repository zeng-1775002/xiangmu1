package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Comment {
    private Integer commentId;
    private String commentContent;
    private Date commentTime;
    private String commentTimeStr;
    private String commentUserName;
    private Integer commentStatus;
    private Integer articleId;
    private List<Reply> replys;
    private User user;

    public String getCommentTimeStr() {
        if(commentTime !=null){
            commentTimeStr=DateUtils.date2String(commentTime,"yyyy-MM-dd HH:mm:ss");
        }

        return commentTimeStr;
    }

    public void setCommentTimeStr(String commentTimeStr) {
        this.commentTimeStr = commentTimeStr;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() throws ParseException {
        if(commentTime !=null){
            String str= DateUtils.date2String(commentTime,"yyyy-MM-dd HH:mm:ss");
            commentTime=DateUtils.string2Date(str,"yyyy-MM-dd HH:mm:ss");
        }
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", commentTime=" + commentTime +
                ", commentUserName='" + commentUserName + '\'' +
                ", commentStatus=" + commentStatus +
                ", articleId=" + articleId +
                ", replys=" + replys +
                ", user=" + user +
                '}';
    }
}
