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
    public User findByNameAndPass(String userName,String userPass) {
        return userDao.findByNameAndPass(userName,userPass);
    }

    @Override
    public void updateLoginStatus(String userName, int status) {
        userDao.updateLoginStatus(userName,status);
    }
}
