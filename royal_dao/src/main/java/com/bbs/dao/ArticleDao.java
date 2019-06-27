package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.*;

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
     *
     * @param userName
     * @return
     */
    @Select("select count(*) from bbs_article_table where senderName=#{userName}")
    int findArticleByName(String userName);



    @Select({"select * from bbs_article_table where title like #{msg}"})
    List<Article> search(String msg);


    /**
     * 查询帖子详情
     *
     * @param articleId
     * @return
     */
    @Select("select * from bbs_article_table where articleId=#{articleId}")
    @Results({
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "sendTime", column = "sendTime"),
            @Result(property = "senderName", column = "senderName"),
            @Result(property = "isTop", column = "isTop"),
            @Result(property = "replyCount", column = "replyCount"),
            @Result(property = "upvoteCount", column = "upvoteCount"),
            @Result(property = "browseCount", column = "browseCount"),
            @Result(property = "zoneId", column = "zoneId"),
            @Result(property = "isReport", column = "isReport"),
            @Result(property = "Comments", column = "articleId", javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.CommentDao.findByArticleId")),
            @Result(property = "user", column = "senderName", javaType = com.bbs.domain.User.class,
                    one = @One(select = "com.bbs.dao.UserDao.findRole"))
    })
    Article articleDetail(Integer articleId);


    @Select("select count(*) from bbs_upvote_table where upvoteUserName=#{userName} and upvoteArticleId=#{articleId}")
    int findLike(@Param("userName") String userName, @Param("articleId") Integer articleId);


    /**
     * 点赞
     *
     * @param userName
     * @param articleId
     */
    @Insert("insert into bbs_upvote_table(upvoteUserName,upvoteArticleId) values(#{userName},#{articleId})")
    void like(@Param("userName") String userName, @Param("articleId") Integer articleId);

    /**
     * 取消点赞
     *
     * @param userName
     * @param articleId
     */
    @Delete("delete from bbs_upvote_table where upvoteUserName=#{userName} and upvoteArticleId=#{articleId}")
    void unLike(@Param("userName") String userName, @Param("articleId") Integer articleId);

    @Update("update bbs_article_table set upvoteCount=#{upvoteCount} where articleId=#{articleId}")
    void upDateAddArticle(@Param("upvoteCount") Integer upvoteCount, @Param("articleId") Integer articleId);

    @Update("update bbs_article_table set upvoteCount=#{upvoteCount} where articleId=#{articleId}")
    void upDateDelArticle(@Param("upvoteCount") Integer upvoteCount, @Param("articleId") Integer articleId);

}