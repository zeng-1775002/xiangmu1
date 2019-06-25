package com.bbs.domain;

import java.util.Date;

public class Report {
    private Integer reportId;
    private String reportContent;
    private Date reportTime;
    private String reportUserName;
    private Integer reportStatus;
    private Integer articleId;

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

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
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

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
