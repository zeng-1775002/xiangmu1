package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PageManageDao {

    /**
     * 分页模糊查询所有文章帖子
     * @param page
     * @param size
     * @return
     */
    @Select("SELECT * FROM bbs_article_table WHERE title LIKE #{title} and senderName LIKE #{sendername}")
    List<Article> findByLike(@Param("page") int page,@Param("size") int size,@Param("title")String title,@Param("sendername")String sendername);

    /**
     * 根据帖子Id进行删除
     * @param id
     */
    @Delete("delete from bbs_article_table where articleId = #{id}")
    void deleteById(@Param("id") Integer id);

    /**
     * 分页查询所有文章帖子
     * @param page
     * @param size
     * @param title
     * @param sendername
     * @return
     */
    @Select("select * from bbs_article_table")
    List<Article> findAllArticle(@Param("page") int page,@Param("size") int size,@Param("title")String title,@Param("sendername")String sendername);

    /**
     * 分页查询所有文章帖子,没有title和sendername参数
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
