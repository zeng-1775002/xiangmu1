package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface PageManageService {

    public List<Article> findAll(int page, int size);
    //置顶.
    void updateIsTop(String articleId);
    //取消.
    void updateIsTops(String articleId);
    public List<Article> findByLike(int page, int size,String title,String sendername);

    void deleteById(Integer articleId);
    //根据id查询
    List<Article> findById(String articleId);

}
