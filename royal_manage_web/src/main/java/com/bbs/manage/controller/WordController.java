package com.bbs.manage.controller;

import com.bbs.domain.Word;
import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Word")
public class WordController {
    @Autowired
    private WordService wordService;

    /**
     * 管理员禁用敏感
     * @param word
     * @return
     */
    @RequestMapping("/ban.do")
    public String ban(String word){
        wordService.ban(word);
        return "ArticlePage";
    }
    /**
     * 管理员启用敏感
     * @param word
     * @return
     */
    @RequestMapping("/open.do")
    public String open(String word){
        wordService.open(word);
        return "ArticlePage";
    }
    /**
     * 管理员添加敏感
     * @param word
     * @return
     */
    public String addWord(String word){
        wordService.addWord(word);
        return "ArticlePage";
    }

    /**
     * 查询所有敏感词
     * @return
     */
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Word> list = wordService.findAllWord();
        mv.addObject("list",list);
        mv.setViewName("ArticlePage");
        return mv;
    }
}
