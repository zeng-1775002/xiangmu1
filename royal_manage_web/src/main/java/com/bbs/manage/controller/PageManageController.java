package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.domain.User;
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

    /**
     * 分页查询所有的帖子信息
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = pageManageService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }


    /**
     * 分页模糊查询所有帖子
     * @param page
     * @param size
     * @param title
     * @param sendername
     * @return
     */
    @RequestMapping("/findByLike.do")
    public ModelAndView findByLike(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "5")int size,@RequestParam(name = "title", required = true) String title, @RequestParam(name = "sendername", required = true) String sendername){
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = pageManageService.findByLike(page,size,"%" + title + "%", "%" + sendername + "%");
        //pageInfo就是一个分页bean.用于封装所有的分页信息
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }

    /**
     * 根据帖子Id就行删除
     * @param articleId
     * @return
     */
    @RequestMapping("/deleteArticle.do")
    public String deleteArticle(@RequestParam(name = "id",required = true)Integer articleId){
        pageManageService.deleteById(articleId);
        return "redirect:findAll.do";
    }

}
