package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public class Article {
    private Integer articleId;
    private String title;
    private String content;
    private Date sendTime;
    private String sendTimeStr;
    private String senderName;
    private Integer isTop;
    private Integer replyCount;
    private Integer upvoteCount;
    private Integer browseCount;
    private Integer zoneId;
    private Integer isReport;
    private List<Comment> Comments;
    private User user;

    public String getSendTimeStr() {
        if(sendTime !=null){
            sendTimeStr=DateUtils.date2String(sendTime,"yyyy-MM-dd HH:mm:ss");
        }

        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public List<Comment> getComments() {
        return Comments;
    }
    public void setComments(List<Comment> comments) {
        Comments = comments;
    }
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() throws ParseException {
        if(sendTime !=null){
            String str= DateUtils.date2String(sendTime,"yyyy-MM-dd HH:mm:ss");
            sendTime=DateUtils.string2Date(str,"yyyy-MM-dd HH:mm:ss");
        }
        return sendTime;

    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", senderName='" + senderName + '\'' +
                ", isTop=" + isTop +
                ", replyCount=" + replyCount +
                ", upvoteCount=" + upvoteCount +
                ", browseCount=" + browseCount +
                ", zoneId=" + zoneId +
                ", isReport=" + isReport +
                ", Comments=" + Comments +
                ", user=" + user +
                '}';
    }
}
