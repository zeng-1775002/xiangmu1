package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("getArticleList.do")
        public ModelAndView getArticleList()throws Exception{
            ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.findAll();
        mv.addObject("articleList",articleList);
            mv.setViewName("index");
            return mv;
    }
    //首页统计今日贴子数
    @RequestMapping("findByTimePost.do")
    public @ResponseBody Integer findByTimePost() throws Exception {
        Integer byTimePost = articleService.findByTimePost();
        System.out.println(byTimePost);
        return byTimePost;
    }
    //首页统计全部帖子数
    @RequestMapping("findAllPost.do")
    public @ResponseBody Integer findAllPost() throws Exception {
        Integer serviceAllPost = articleService.findAllPost();
        return serviceAllPost;
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

    /**
     * 查找个人发帖数
     * @return
     */
    @RequestMapping("/selectArticle.do")
    @ResponseBody
    public String selectArticle(String userName){
        int count=articleService.findArticleByName(userName);
        System.out.println(count);
        return count+"";
    }

}
