package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {
    @Select("select * from bbs_article_table")
    public List<Article> findAll();
}
