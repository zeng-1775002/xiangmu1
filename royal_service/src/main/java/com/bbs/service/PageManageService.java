package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface PageManageService {

    public List<Article> findAll(int page, int size);
}
