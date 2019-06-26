package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getArticle.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Article> list = articleService.findAll();
        mv.addObject("articleList",list);
        mv.setViewName("index");
        return mv;
    }
//    发帖功能
    @RequestMapping("/save.do")
    public String save(Article article){
        article.setSendTime(new Date());
        article.setSenderName("小明");//修改
        article.setIsTop(1);
        article.setReplyCount(0);
        article.setUpvoteCount(0);
        article.setBrowseCount(0);
        article.setZoneId(1);//修改
        article.setIsReport(0);
        articleService.save(article);
        return "redirect:getArticle.do";
    }
}
