package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean findByName(String userName) {
        int i = userDao.findByName(userName);
        if (i == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 注册用户
     *
     * @param user
     */
    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public User findRole(String userName) {
        return userDao.findRole(userName);
    }

    @Override
    public void updateEmail(String email, String userName) {
        userDao.updateEmail(email, userName);
    }

    @Override
    public void UpdateUserPass(String newPassword, String userName) {
        userDao.UpdateUserPass(newPassword, userName);

    }

    @Override
    public Boolean findOldUserPass(String oldPassword, String userName) {
        User user = userDao.findOldUserPass(oldPassword, userName);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean findNewEmail(String email, String userName) {
        User user = userDao.findNewEmail(email, userName);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户升级
     *
     * @param userName
     */
    @Override
    public void updateUserRole(String userName) {
        userDao.updateUserRole(userName);
    }


    @Override
    public User findByNameAndPass(String userName, String userPass) {
        return userDao.findByNameAndPass(userName, userPass);
    }

    @Override
    public void updateLoginStatus(String userName, int status) {
        userDao.updateLoginStatus(userName, status);
    }

}