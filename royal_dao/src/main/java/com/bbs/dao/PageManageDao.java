package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    //置顶
    @Update("update bbs_article_table set isTop = 1 where articleId = #{articleId}")
    void updateIsTop(String articleId);

    //取消
    @Update("update bbs_article_table set isTop = 0 where articleId = #{articleId}")
    void updateIsTops(String articleId);
}
