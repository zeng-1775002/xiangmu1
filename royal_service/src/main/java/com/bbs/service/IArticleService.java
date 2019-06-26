package com.bbs.service;

public interface IArticleService {
    //获取全部帖子数
    Integer findAllPost()throws Exception;

    //获取今日帖子数
    Integer findByTimePost()throws Exception;
}
