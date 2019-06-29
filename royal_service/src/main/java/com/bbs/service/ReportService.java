package com.bbs.service;

import com.bbs.domain.Report;

import java.util.List;

public interface ReportService {
    //添加举报内容
    void saveReport(Report report);


    public List<Report> findAll(int page, int size);

    void updateReport(String reportId);

    void updateReports(String reportId);
}
