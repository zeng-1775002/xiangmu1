package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
//    查询所有帖子
    @Override
    public List<Article> findAll() {
        PageHelper.startPage(1,10);
        return articleDao.findAll();
    }
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
//  发帖
    @Override
    public void save(Article article) {
       articleDao.save(article);
    }

    /**
     * 查找个人发帖数
     * @param userName
     * @return
     */
    @Override
    public int findArticleByName(String userName) {
        return articleDao.findArticleByName(userName);
    }
}
