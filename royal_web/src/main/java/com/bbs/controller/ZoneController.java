package com.bbs.controller;

import com.bbs.domain.ZoneTable;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;


    @RequestMapping("/insertNewZone.do")
    public String insertNewZone(@RequestParam(name = "zoneName", required = true)String zoneName,
                              @RequestParam(name = "reason", required = true)String reason,
                                HttpSession session){

        String userName = (String) session.getAttribute("username");
        zoneService.insertNewZone(zoneName,reason,userName);

        return "index";
    }


//    @RequestMapping("/findNewZone.do")
//    public ModelAndView findNewZone(){
//        ModelAndView mv = new ModelAndView();
//        List<ZoneTable> zoneList = zoneService.findNewZone();
//        mv.addObject("zoneList",zoneList);
//        mv.setViewName("index");
//        return mv;
//    }
}
