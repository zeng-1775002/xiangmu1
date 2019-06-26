package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> findAll();

    void save(Article article);

    int findArticleByName(String userName);
}
