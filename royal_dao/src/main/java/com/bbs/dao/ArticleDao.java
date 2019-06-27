package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    @Select("select * from bbs_article_table")
    public List<Article> findAll();

    //发帖功能
    @Insert("insert into bbs_article_table(title,content,sendTime,senderName,isTop,replyCount,upvoteCount,browseCount,zoneId,isReport)values(#{title},#{content},#{sendTime},#{senderName},#{isTop},#{replyCount},#{upvoteCount},#{browseCount},#{zoneId},#{isReport})")
    void save(Article article);

    /**
     * 查找个人发帖数
     * @param userName
     * @return
     */
    @Select("select count(*) from bbs_article_table where senderName=#{userName}")
    int findArticleByName(String userName);
}
