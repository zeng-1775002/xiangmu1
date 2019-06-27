package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    void save(Article article);

    int findArticleByName(String userName);


    List<Article> search(String msg);



    Article articleDetail(Integer articleId);

    Boolean findLike(String userName, Integer articleId);

    void like(String userName, Integer articleId);

    void unLike(String userName, Integer articleId);
}