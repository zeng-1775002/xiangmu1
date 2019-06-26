package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findRole.do")
    public String findRole(Model model){
        String name="zhangsan";
        User user = userService.findRole(name);
        System.out.println(user);
        ModelAndView mv = new ModelAndView();
        model.addAttribute("user",user);
        return "userInfo";
    }
   /* @RequestMapping("/updateEmailAndPic.do")
    public ModelAndView updateEmailAndPic(@RequestBody User user, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        // 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()){
            file.mkdirs();
        }
        // 创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 解析request对象
        List<FileItem> list = fileUpload.parseRequest(request);
        String filename=null;
        for (FileItem fileItem : list) {
            if(fileItem.isFormField()){

            }else{
                // 上传文件项
                // 获取到上传文件的名称
                filename = fileItem.getName();
                //上传文件
                fileItem.write(new File(file,filename));
                fileItem.delete();
            }
        }
        String picUrl=null;
        if (request != null) {
            picUrl = request.getSession().getServletContext().getRealPath(filename);
            String sub=picUrl.substring(picUrl.lastIndexOf("\\")+1);
            picUrl ="uploads/"+sub;
            System.out.println(picUrl);
        }
        userService.updateEmail(user.getUserName(),user.getEmail(),picUrl);
        return mv;
    }*/
    @RequestMapping("/updateEmailAndPic.do")
    public ModelAndView updateEmailAndPic(String email,String userName) throws Exception {
        ModelAndView mv = new ModelAndView();
        userService.updateEmail(email,userName);
        Boolean b=userService.findNewEmail(email,userName);
            if(b){
                mv.addObject("b","修改成功");
            }
        mv.setViewName("userInfo");
        return mv;
    }
    @RequestMapping("/findOldUserPass.do")
    @ResponseBody
    public String findOldUserPass(String oldPassword,String userName) throws Exception {
        Boolean b=userService.findOldUserPass(oldPassword,userName);
        if(b){
            return "true";
        }else {
            return "false";
        }

    }
    @RequestMapping("/updateUserPass.do")
    public String updateUserPass(String newPassword,String userName) throws Exception {
        userService.UpdateUserPass(newPassword,userName);
        return "userPwd";
    }

    /**
     * 用户升级
     * @param
     * @param userName
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUserRole.do")
    public ModelAndView updateUserRole(String userName) throws Exception {
        ModelAndView mv = new ModelAndView();
        userService.updateUserRole(userName);
        User user = userService.findRole(userName);
        if(user.getRole()==2){
            mv.addObject("str","修改成功");
        }
        mv.setViewName("userUpdate");
        return mv;
    }

}
