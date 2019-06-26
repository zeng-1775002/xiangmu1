package com.bbs.service;

import com.bbs.domain.User;

public interface UserService {

    User findByNameAndPass(String userName,String userPass);

    void updateLoginStatus (String userName,int status);



    public User findRole(String userName);



    void updateEmail(String email,String userName);




    void UpdateUserPass(String newPassword, String userName);

    Boolean findOldUserPass(String oldPassword, String userName);

    Boolean findNewEmail(String email, String userName);

    void updateUserRole(String userName);
}