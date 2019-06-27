package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class Reply {
    //回复编号
    private Integer replyId;
    //回复内容
    private String replyContent;
    //回复时间
    private Date replyTime;
    private String replyTimeStr;

    //回复人
    private String replyUserName;
    //评论编号
    private Integer commentId;
    private User user;

    public String getReplyTimeStr() {
        if(replyTime !=null){
            replyTimeStr=DateUtils.date2String(replyTime,"yyyy-MM-dd HH:mm:ss");
        }
        return replyTimeStr;
    }

    public void setReplyTimeStr(String replyTimeStr) {
        this.replyTimeStr = replyTimeStr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() throws ParseException {
        return replyTime;
    }


    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                ", replyUserName='" + replyUserName + '\'' +
                ", commentId=" + commentId +
                ", user=" + user +
                '}';
    }
}
