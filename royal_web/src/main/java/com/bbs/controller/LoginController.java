package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findByNameAndPass.do")
    public ModelAndView findByNameAndPass(@RequestParam(name = "userName", required = true)String userName,
                                          @RequestParam(name = "userPass", required = true)String userPass,HttpServletRequest request){
        User user = userService.findByNameAndPass(userName,userPass);
        ModelAndView mv = new ModelAndView();
        if (user != null){
            userService.updateLoginStatus(userName,1);
            mv.addObject("user",user);
            mv.setViewName("loginSuccess");
         request.getSession().setAttribute("userName",userName);
        }else{

            mv.setViewName("loginFailed");
        }
        return mv;
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("/exit.do")
    public String exit(String userName,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        userService.updateLoginStatus(userName,0);
        return "redirect:/index.jsp";
    }
}
