package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PageManageDao {

    /**
     * 分页查询所有文章帖子
     * @param page
     * @param size
     * @return
     */
    @Select("select * from bbs_article_table")
    List<Article> findAll(@Param("page") int page,@Param("size") int size);
}
