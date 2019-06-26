package com.bbs.service.impl;

import com.bbs.dao.IArticleDao;
import com.bbs.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    //获取全部帖子数
    @Override
    public Integer findAllPost()throws Exception {
        return articleDao.findAllPost();
    }

    //获取今日帖子数
    @Override
    public Integer findByTimePost() throws Exception {
        return  articleDao.findByTimePost();
    }
}
