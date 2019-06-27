package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.domain.User;
import com.bbs.service.UserService;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
       List<User> userList = userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("UserPage");
        return mv;
    }

    /**
     * 模糊查询用户名和用户组信息
     * @param username
     * @param role
     * @return
     */
    @RequestMapping("/findByLike.do")
    public ModelAndView findByLike(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "5")int size,@RequestParam(name = "username", required = true) String username, @RequestParam(name = "role", required = true) String role) {
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.findByLike(page,size,"%" + username + "%", "%" + role + "%");
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("UserPage");
        return mv;
    }

}
