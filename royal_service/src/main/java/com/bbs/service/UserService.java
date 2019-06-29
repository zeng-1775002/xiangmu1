package com.bbs.service;

import com.bbs.domain.User;
import com.github.pagehelper.Page;
import com.sun.glass.ui.Size;

import java.util.List;

import java.util.List;

public interface UserService {

    User findByNameAndPass(String userName,String userPass);

    void updateLoginStatus (String userName,int status);



    public User findRole(String userName);



    void updateEmail(String email,String userName);




    void UpdateUserPass(String newPassword, String userName);

    Boolean findOldUserPass(String oldPassword, String userName);

    Boolean findNewEmail(String email, String userName);

    void updateUserRole(String userName);

    List<User> findLoadUser();


    void register(User user);

    Boolean findByName(String userName);

    List<User> findAll(int page,int size);

    List<User> findByLike(int Page,int Size,String username, String role);

    void forbiddenUser1(int userId);

    void forbiddenUser0(int userId);

    void upUserRole(int userId);
}

