package com.bbs.service;

import com.bbs.domain.User;

public interface ManageService {

    /**
     * 根据用户名和密码查询管理员
     * @param username
     * @return
     */
    public User findByManager(String username);
}
