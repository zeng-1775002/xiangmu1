package com.bbs.service;

import com.bbs.domain.User;

public interface UserService {

    User findByNameAndPass(String userName,String userPass);

    void updateLoginStatus (String userName,int status);
}
