package com.bbs.manage.controller;

import com.bbs.domain.ZoneApplyTable;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zoneApply")
public class ZoneApplyController {
    @Autowired
    private ZoneService zoneService;


    @RequestMapping("/findAllZoneApply.do")
    public ModelAndView findAllZoneApply(){
        ModelAndView mv = new ModelAndView();

        List<ZoneApplyTable> list = zoneService.findAllZoneApply();
        mv.addObject("list",list);
        mv.setViewName("zone");

        return mv;
    }



    @RequestMapping("/applyAllow.do")
    public String applyAllow(@RequestParam(name = "zoneName",required = true)String zoneName,
                            @RequestParam(name = "userName",required = true)String userName){

            zoneService.updateStatus(zoneName,userName,1);
            zoneService.addNewZone(zoneName,2);

            return "redirect:findAllZoneApply.do";
    }

    @RequestMapping("/applyReject.do")
    public String applyReject(@RequestParam(name = "zoneName",required = true)String zoneName,
                             @RequestParam(name = "userName",required = true)String userName){

        zoneService.updateStatus(zoneName,userName,0);

        return "redirect:findAllZoneApply.do";
    }



}
