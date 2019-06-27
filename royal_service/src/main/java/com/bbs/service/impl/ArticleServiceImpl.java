package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    //首页统计全部帖子数
    @Override
    public Integer findAllPost()throws Exception {
        return articleDao.findAllPost();
    }

    //首页统计今日贴子数
    @Override
    public Integer findByTimePost() throws Exception {
        return  articleDao.findByTimePost();
    }
//  发帖
    @Override
    public void save(Article article) {
       articleDao.save(article);
    }
    //查询全部帖子状态
    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
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
