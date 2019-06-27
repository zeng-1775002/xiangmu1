package com.bbs.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleDao {
    //获取全部帖子数
    @Select("select count(*) from bbs_article_table")
    Integer findAllPost()throws Exception;

    //获取今日帖子数
    @Select("SELECT COUNT(*) FROM bbs_article_table WHERE DATE_FORMAT(NOW(),'YY-MM-DD') = DATE_FORMAT('sendTime','YY-MM-DD');")
    Integer findByTimePost()throws Exception;

}
