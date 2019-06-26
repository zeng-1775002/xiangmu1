package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface PostManageService {

    /**
     * 模糊查询标题和发帖人
     * @param title
     * @param sendername
     * @return
     */
    List<Article> findByLike(String title, String sendername);
}
