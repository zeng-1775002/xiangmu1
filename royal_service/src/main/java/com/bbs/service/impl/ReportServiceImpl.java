package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;
    @Override
    public void saveReport(Report report) {
        reportDao.saveReport(report);
    }

    @Override
    public List<Report> findAll(int page, int size) {
        //利用pageHelper进行分页查询
        PageHelper.startPage(page,size);
        return reportDao.findAll(page,size);
    }

    @Override
    public void updateReport(String reportId) {
        reportDao.updateReport(reportId);
    }

    @Override
    public void updateReports(String reportId) {
        reportDao.updateReports(reportId);
    }
}
