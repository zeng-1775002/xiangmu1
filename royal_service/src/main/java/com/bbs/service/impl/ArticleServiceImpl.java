package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

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

    @Override
    public void save(Article article) {
       articleDao.save(article);
    }
}
