package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
//    查询所有帖子
    @Override
    public List<Article> search(String msg) {
        return articleDao.search(msg);

    }
//  发帖
    @Override
    public void save(Article article) {
       articleDao.save(article);
    }
    //查询全部帖子状态
    @Override
    public List<Article> findAll(Integer zoneId,int page,int size) throws Exception {
        if (zoneId == null) {
            zoneId = 1;
        }
        PageHelper.startPage(page, size);
        return articleDao.findAll(zoneId);
    }

    /**
     * 查找个人发帖数
     * @param userName
     * @return
     */
    @Override
    public int findArticleByName(String userName) {
        return articleDao.findArticleByName(userName);
    }

    /**
     * 查询帖子详情
     * @param articleId
     * @return
     */
    @Override
    public Article articleDetail(Integer articleId) {
        return articleDao.articleDetail(articleId);
    }

    /**
     * 发表评论
     * @return
     */
    @Override
    public void comment(String userName, Integer articleId, String commentContent) {
        articleDao.comment(userName,articleId,commentContent,0,new Date());
    }

    @Override
    public void reply(String replyContent, Integer commentId, String userName) {
        articleDao.reply(replyContent,new Date(),userName,commentId);
    }





    /**
     * 点赞状态
     *
     * @param userName
     * @param articleId
     * @return
     */
    @Override
    public Boolean findLike(String userName, Integer articleId) {

        int count = articleDao.findLike(userName, articleId);
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 点赞
     *
     * @param userName
     * @param articleId
     */
    @Override
    public void like(String userName, Integer articleId) {
        articleDao.like(userName, articleId);
        Article article = articleDao.articleDetail(articleId);
        Integer upvoteCount = article.getUpvoteCount();
        upvoteCount += 1;
        articleDao.upDateAddArticle(upvoteCount,articleId);
    }

    /**
     * 取消点赞
     *
     * @param userName
     * @param articleId
     */
    @Override
    public void unLike(String userName, Integer articleId) {
        articleDao.unLike(userName, articleId);
        Article article = articleDao.articleDetail(articleId);
        Integer upvoteCount = article.getUpvoteCount();
        upvoteCount -= 1;
        articleDao.upDateDelArticle(upvoteCount,articleId);

    }
    //首页统计全部帖子数
    @Override
    public Integer findAllPost()throws Exception {
        return articleDao.findAllPost();
    }

    //首页统计今日贴子数
    @Override
    public Integer findByTimePost() throws Exception {
        return  articleDao.findByTimePost();
    }
}
