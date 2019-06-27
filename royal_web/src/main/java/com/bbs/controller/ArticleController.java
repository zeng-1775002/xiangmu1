package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.ZoneTable;
import com.bbs.service.ArticleService;
import com.bbs.service.ZoneService;
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
    @Autowired
    private ZoneService zoneService;

    @RequestMapping("/getArticle.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Article> list = articleService.findAll();
        List<ZoneTable> zoneList = zoneService.findNewZone();
        mv.addObject("zoneList",zoneList);
        mv.addObject("articleList",list);

        mv.setViewName("index");
        return mv;
    }
    //首页统计今日贴子数.
    @RequestMapping("findByTimePost.do")
    public @ResponseBody Integer findByTimePost() throws Exception {
        Integer byTimePost = articleService.findByTimePost();
        System.out.println(byTimePost);
        return byTimePost;
    }
    //首页统计全部帖子数.
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
