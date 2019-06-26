package com.bbs.domain;

import java.util.Date;
//举报表
public class Report {
    private int reportId;
    private String reportContent;
    private Date reportTime;
    private String reportUserName;
    private int reportStatus;
    private int articleId;

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportContent='" + reportContent + '\'' +
                ", reportTime=" + reportTime +
                ", reportUserName='" + reportUserName + '\'' +
                ", reportStatus=" + reportStatus +
                ", articleId=" + articleId +
                '}';
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public int getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(int reportStatus) {
        this.reportStatus = reportStatus;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}