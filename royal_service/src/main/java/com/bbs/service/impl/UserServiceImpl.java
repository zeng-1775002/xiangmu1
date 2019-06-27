package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.Article;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User findRole(String userName) {
        return userDao.findRole(userName);
    }

    @Override
    public void updateEmail(String email,String userName) {
        userDao.updateEmail(email,userName);
    }

    @Override
    public void UpdateUserPass(String newPassword, String userName) {
        userDao.UpdateUserPass(newPassword,userName);

    }

    @Override
    public Boolean findOldUserPass(String oldPassword, String userName) {
        User user=userDao.findOldUserPass(oldPassword,userName);
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public Boolean findNewEmail(String email, String userName) {
       User user= userDao.findNewEmail(email,userName);
       if(user!=null){
           return true;
       }else{
           return false;
       }
    }

    /**
     * 用户升级
     * @param userName
     */
    @Override
    public void updateUserRole(String userName) {
        userDao.updateUserRole(userName);
    }




    @Override
    public User findByNameAndPass(String userName,String userPass) {
        return userDao.findByNameAndPass(userName,userPass);
    }

    @Override
    public void updateLoginStatus(String userName, int status) {
        userDao.updateLoginStatus(userName,status);
    }

    /**
     * 后台查询所有用户和用户组信息
     * @return
     */
    @Override
    public List<User> findAll(int page,int size) {

        PageHelper.startPage(page,size);
        return userDao.findAll(page,size);
    }

    @Override
    public List<User> findByLike(int page,int size,String username, String role) {
        /**
         * 如果用户名为空,就执行查询全部
         * 如果不为空,就执行模糊查询
         */
        if (username=="" && role ==""){
            //利用pageHelper进行分页查询
            PageHelper.startPage(page,size);
            return userDao.findAllUser(page,size,username,role);
        }
        //利用pageHelper进行分页查询
        PageHelper.startPage(page,size);
        List<User> userList = userDao.findByLike(page, size, username, role);
        return userList;

    }
}

