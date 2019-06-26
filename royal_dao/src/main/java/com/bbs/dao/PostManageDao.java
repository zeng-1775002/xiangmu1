package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostManageDao {

    /**
     * 模糊查询标题和发帖人
     * @param title
     * @param sendername
     * @return
     */
    @Select("SELECT * FROM bbs_article_table WHERE title LIKE #{title} and senderName LIKE #{sendername}")
    List<Article> findByLike(@Param("title") String title, @Param("sendername") String sendername);
}
