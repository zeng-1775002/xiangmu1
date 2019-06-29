package com.bbs.dao;

import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommentDao {
    @Select("select * from bbs_comment_table where articleId=#{articleId}")
    @Results({
            @Result(id = true,property = "commentId",column = "commentId"),
            @Result(property = "commentContent",column = "commentContent"),
            @Result(property = "commentTime",column = "commentTime"),
            @Result(property = "commentUserName",column = "commentUserName"),
            @Result(property = "commentStatus",column = "commentStatus"),
            @Result(property = "articleId",column = "articleId"),
            @Result(property = "replys",column = "commentId",javaType = java.util.List.class,
            many = @Many(select = "com.bbs.dao.ReplyDao.findBycommentId")),
            @Result(property = "user",column = "commentUserName",javaType = com.bbs.domain.User.class,
                    one=@One(select = "com.bbs.dao.UserDao.findRole"))
    })
    public List<Comment> findByArticleId(Integer articleId);
}
