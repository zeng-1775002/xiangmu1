package com.bbs.manage.controller;

import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("manageReport")
public class ReportController {
    @Autowired
    private ReportService reportService;
    /**
     * 分页查询所有的帖子信息
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        List<Report> reportList = reportService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(reportList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ReportPage");
        return mv;
    }
    /**
            * 屏蔽帖子状态
     * @param reportId
     * @return
             */
    @RequestMapping("/updateReport1.do")
    public String updateReport(@RequestParam(name = "id",required = true)String reportId){
        reportService.updateReport(reportId);
        return "redirect:findAll.do";
    }
    /**
     * 屏蔽帖子状态
     * @param reportId
     * @return
     */
    @RequestMapping("/updateReport2.do")
    public String updateReports(@RequestParam(name = "id",required = true)String reportId){
        reportService.updateReports(reportId);
        return "redirect:findAll.do";
    }
}
