package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {
    @Select("select * from bbs_article_table")
    public List<Article> findAll();

//    发帖功能
//    `title`,`content`,`sendTime`,`senderName`,`isTop`,`replyCount`,`upvoteCount`,`browseCount`,`zoneId`,`isReport`
    @Insert("insert into bbs_article_table(title,content,sendTime,senderName,isTop,replyCount,upvoteCount,browseCount,zoneId,isReport)" +
            "values(#{title},#{content},#{sendTime},#{senderName},#{isTop},#{replyCount},#{upvoteCount},#{browseCount},#{zoneId},#{isReport})")
    void save(Article article);
}
