package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.User;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getArticle.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Article> list = articleService.findAll();
        mv.addObject("articleList", list);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/search.do")
    public ModelAndView search(String msg) {
        msg = "%" + msg + "%";
        ModelAndView mv = new ModelAndView();
        List<Article> list = articleService.search(msg);
        mv.setViewName("search-show");
        mv.addObject("articleList", list);
        return mv;
    }

    //    发帖功能
    @RequestMapping("/save.do")
    public String save(Article article) {
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
     *
     * @return
     */
    @RequestMapping("/selectArticle.do")
    @ResponseBody
    public String selectArticle(String userName) {
        int count = articleService.findArticleByName(userName);
        System.out.println(count);
        return count + "";
    }

    /**
     * 点赞
     *
     * @param userName
     * @param articleId
     */
    @RequestMapping("/findLike.do")
    @ResponseBody
    public String findLike(String userName, Integer articleId) {
        Boolean flag = articleService.findLike(userName, articleId);
        if (flag) {
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 点赞
     *
     * @param userName
     * @param articleId
     */
    @RequestMapping("/like.do")
    public String like(String userName, Integer articleId) {
        articleService.like(userName, articleId);
        return "redirect:article/articleDetail.do";
    }

    /**
     * 取消点赞
     *
     * @param userName
     * @param articleId
     */
    @RequestMapping("/unLike.do")
    public String unLike(String userName, Integer articleId) {
        articleService.unLike(userName, articleId);
        return "redirect:article/articleDetail.do";
    }


    /**
     * 查询帖子详情
     *
     * @return
     */
    @RequestMapping("/articleDetail.do")
    public ModelAndView articleDetail(Integer articleId) {
        Article article = articleService.articleDetail(articleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("article", article);
        mv.setViewName("getArticle");
        return mv;
    }


}
