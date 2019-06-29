package com.bbs.controller;

import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    //举报上传
    @RequestMapping("/setReport.do")
    public String setReport(Report report){
        report.setReportStatus(0);//默认为0,未处理
        report.setReportTime(new Date());//举报时间
        reportService.saveReport(report);//传递内容
        return "redirect:/index.jsp";
    }
}
