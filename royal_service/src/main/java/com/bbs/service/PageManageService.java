package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface PageManageService {

    public List<Article> findByLike(int page, int size,String title,String sendername);

    void deleteById(Integer articleId);

    List<Article> findAll(int page, int size);
}
