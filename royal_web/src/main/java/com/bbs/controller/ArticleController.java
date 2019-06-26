package com.bbs.controller;

import com.bbs.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @RequestMapping("getArticleList.do")
        public ModelAndView getArticleList()throws Exception{
            ModelAndView mv = new ModelAndView();
            Integer articleAll= articleService.findAllPost();//获取全部帖子数
        Integer byTimePost = articleService.findByTimePost();//获取今日帖子数
        mv.addObject("byTimePost",byTimePost);
        mv.addObject("articleAll",articleAll);
            mv.setViewName("index");

            System.out.println(articleAll);
        System.out.println(byTimePost);

            return mv;
    }
}
