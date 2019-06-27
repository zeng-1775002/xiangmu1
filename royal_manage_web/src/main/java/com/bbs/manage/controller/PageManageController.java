package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.PageManageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author Lyq
 * @Profession Programmer
 */
@Controller
@RequestMapping("/pageManage")
public class PageManageController {

    @Autowired
    private PageManageService pageManageService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = pageManageService.findAll(page,size);
        //pageInfo就是一个分页bean.用于封装所有的分页信息
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }
    //置顶
    @RequestMapping("changeStatus1.do")
    public String updateIsTop(@RequestParam(name = "id",required = true)String articleId){
        pageManageService.updateIsTop(articleId);
        return "redirect:findAll.do";
    }
    //取消
    @RequestMapping("changeStatus2.do")
    public String updateIsTops(@RequestParam(name = "id",required = true)String articleId){
        pageManageService.updateIsTops(articleId);
        return "redirect:findAll.do";
    }
}
