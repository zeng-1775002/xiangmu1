package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {
    //首页统计全部帖子数
    Integer findAllPost()throws Exception;

    //首页统计今日贴子数
    Integer findByTimePost()throws Exception;

    //新增
    void save(Article article);

    //查询全部帖子的状态
    public List<Article> findAll(Integer zoneId,int page,int size) throws Exception;

    int findArticleByName(String userName);



    void comment(String userName, Integer articleId, String commentContent);

    void reply(String replyContent, Integer commentId, String userName);


    List<Article> search(String msg);



    Article articleDetail(Integer articleId);

    Boolean findLike(String userName, Integer articleId);

    void like(String userName, Integer articleId);



    void unLike(String userName, Integer articleId);
}