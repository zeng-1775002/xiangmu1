package com.bbs.service.impl;

import com.bbs.dao.ManageDao;
import com.bbs.domain.User;
import com.bbs.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Lyq
 * @Profession Programmer
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManageService {

    @Autowired
    private ManageDao manageDao;

    @Override
    public User findByManager(String username) {

        return manageDao.findByManage(username);


    }
}
