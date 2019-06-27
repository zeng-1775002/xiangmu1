package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    //首页统计全部帖子数
    @Select("select count(*) from bbs_article_table")
    Integer findAllPost()throws Exception;

    //首页统计今日贴子数
    @Select("SELECT COUNT(*) FROM bbs_article_table WHERE TO_DAYS(sendTime) = TO_DAYS(NOW());")
    Integer findByTimePost()throws Exception;

    //查询全部帖子的状态
    @Select("select * from bbs_article_table")
    public List<Article> findAll();

//    发帖功能
//    `title`,`content`,`sendTime`,`senderName`,`isTop`,`replyCount`,`upvoteCount`,`browseCount`,`zoneId`,`isReport`
    @Insert("insert into bbs_article_table(title,content,sendTime,senderName,isTop,replyCount,upvoteCount,browseCount,zoneId,isReport)" +
            "values(#{title},#{content},#{sendTime},#{senderName},#{isTop},#{replyCount},#{upvoteCount},#{browseCount},#{zoneId},#{isReport})")
    void save(Article article);

    /**
     * 查找个人发帖数
     * @param userName
     * @return
     */
    @Select("select count(*) from bbs_article_table where senderName=#{userName}")
    int findArticleByName(String userName);

}
