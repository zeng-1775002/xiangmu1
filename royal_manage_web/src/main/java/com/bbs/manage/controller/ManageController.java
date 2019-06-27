package com.bbs.manage.controller;

import com.bbs.domain.User;
import com.bbs.service.ManageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author Lyq
 * @Profession Programmer
 */
@Controller
@RequestMapping("/manage")
public class ManageController {


    @Autowired
    private ManageService manageService;

    @RequestMapping("/findByManager.do")
    public ModelAndView findByManager(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "userpass", required = true) String userpass) {
        ModelAndView mv = new ModelAndView();
        User user = manageService.findByManager(username);
        /**
         * 判断角色是否==3
         *      是: 判断密码
         *          正确: 跳转成功页面
         *          错误: 向域中存入错误信息
         *      不是: 向域中存入错误信息
         */
        String s = "请以管理员身份登录!";
        if (user != null) {
            if (user.getRole() == 3) {
                if (userpass.equalsIgnoreCase(user.getUserPass())) {
                    //正确,跳转成功页面
                    mv.setViewName("main");
                } else {
                    //错误,向域中存入错误信息
                    mv.setViewName("login");
                    mv.addObject("str", s);
                }
            } else {
                //向域中存入错误信息
                mv.addObject("str", s);
                mv.setViewName("login");
            }
        }else{
            //向域中存入错误信息
            mv.addObject("str", s);
            mv.setViewName("login");
        }

        return mv;
    }
}
