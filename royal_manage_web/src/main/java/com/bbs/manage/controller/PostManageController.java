package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.PostManageService;
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
@RequestMapping("/postManage")
public class PostManageController {

    @Autowired
    private PostManageService postManageService;

    @RequestMapping("/findByLike.do")
    public ModelAndView findByLike(@RequestParam(name = "title", required = true) String title, @RequestParam(name = "sendername", required = true) String sendername) {
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = postManageService.findByLike("%" + title + "%", "%" + sendername + "%");
        mv.addObject("article", articleList);
        mv.setViewName("ArticlePage2");
        return mv;
    }
}
