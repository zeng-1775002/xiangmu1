package com.bbs.controller;

import com.bbs.domain.*;
import com.bbs.domain.Article;
import com.bbs.domain.ZoneTable;
import com.bbs.domain.User;
import com.bbs.service.ArticleService;
import com.bbs.service.UserService;
import com.bbs.service.WordService;

import com.bbs.service.ZoneService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private WordService wordService;
    /**
     * 未登陆首页查询数据展示
     * @return
     */
    @Autowired
    private ZoneService zoneService;

    @RequestMapping("/getArticle.do")
    public ModelAndView findAll(Integer zoneId,@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "10")int size) throws Exception{
        List<Article> list = articleService.findAll(zoneId,page,size);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("articleList", list);
        List<ZoneTable> zoneList = zoneService.findNewZone();
        mv.addObject("zoneList",zoneList);
        List<Word> words = wordService.findAll();
        for (Word word : words) {
            //先按字符串长度拼接*
            String str = "";
            for (int a = 1; a <= word.getWord().length(); a++) {
                str =str+"*";
            };
        //过滤敏感词
        for (Article article : list){
                //遍历替换
                //改文件标题
                String replaceTitle = article.getTitle().replace(word.getWord(), str);
                article.setTitle(replaceTitle);
                //改文件内容
                String replaceContent = article.getContent().replace(word.getWord(), str);
                article.setContent(replaceContent);
            }

        }
        //查找所有在线用户
        List<User> users=userService.findLoadUser();
        mv.addObject("articleList",list);

        mv.addObject("users",users);
        mv.setViewName("index");
        return mv;
    }

    /**
     * 首页统计今日贴子数.
     * @return
     * @throws Exception
     */
    @RequestMapping("findByTimePost.do")
    public @ResponseBody Integer findByTimePost() throws Exception {
        Integer byTimePost = articleService.findByTimePost();
        System.out.println(byTimePost);
        return byTimePost;
    }

    /**
     * 首页统计全部帖子数.
     * @return
     * @throws Exception
     */
    @RequestMapping("findAllPost.do")
    public @ResponseBody Integer findAllPost() throws Exception {
        Integer serviceAllPost = articleService.findAllPost();
        return serviceAllPost;
    }

    /**
     * 模糊搜索帖子
     * @param msg
     * @return
     */
    @RequestMapping("/search.do")
    public ModelAndView search(String msg) {
        msg = "%" + msg + "%";
        ModelAndView mv = new ModelAndView();
        List<Article> list = articleService.search(msg);
        mv.setViewName("search-show");
        mv.addObject("articleList", list);
        return mv;
    }

    //    发帖功能
    @RequestMapping("save.do")
    public String save(Article article, HttpSession session, HttpServletRequest request){
        article.setSendTime(new Date());
        article.setSenderName((String) session.getAttribute("userName"));
        article.setIsTop(0);
        article.setReplyCount(0);
        article.setUpvoteCount(0);
        article.setBrowseCount(0);
        article.setZoneId(1);
        article.setIsReport(0);
        articleService.save(article);
        return "redirect:getArticle.do";
    }
    /**
     * 查找个人发帖数
     * @return
     */
    @RequestMapping("/selectArticle.do")
    @ResponseBody
    public String selectArticle(String userName){
        int count=articleService.findArticleByName(userName);
        System.out.println(count);
        return count+"";
    }

    /**
     * 点赞状态
     *
     * @param userName
     * @param articleId
     */
    @RequestMapping("/findLike.do")
    @ResponseBody
    public String findLike(String userName, Integer articleId) {
        Boolean flag = articleService.findLike(userName, articleId);
        if (flag) {
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 点赞
     *
     * @param userName
     * @param articleId
     */
    @RequestMapping("/like.do")
    public String like(String userName, Integer articleId) {
        articleService.like(userName, articleId);
        return "redirect:article/articleDetail.do";
    }

    /**
     * 取消点赞
     *
     * @param userName
     * @param articleId
     */
    @RequestMapping("/unLike.do")
    public String unLike(String userName, Integer articleId) {
        articleService.unLike(userName, articleId);
        return "redirect:article/articleDetail.do";
    }



    /**
     * 查询帖子详情
     * @return
     */
    @RequestMapping("/articleDetail.do")
    public ModelAndView articleDetail(Integer articleId){
        Article article=articleService.articleDetail(articleId);
        List<Word> words = wordService.findAll();
        for (Word word : words) {
            //先按字符串长度拼接*
            String str = "";
            for (int a = 1; a <= word.getWord().length(); a++) {
                str =str+"*";
            };
           //改文件标题
            String replaceTitle = article.getTitle().replace(word.getWord(), str);
            article.setTitle(replaceTitle);
            //改文件内容
            String replaceContent = article.getContent().replace(word.getWord(), str);
            article.setContent(replaceContent);
            //改评论内容
            for (Comment comment : article.getComments()) {
                String replaceCommentContent = comment.getCommentContent().replace(word.getWord(), str);
                comment.setCommentContent(replaceCommentContent);
                //改回复评论功能
                for (Reply reply : comment.getReplys()) {
                    String replaceReplyContent = reply.getReplyContent().replace(word.getWord(), str);
                    reply.setReplyContent(replaceReplyContent);
                }
            }

        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("article",article);
        mv.setViewName("getArticle");
        return mv;
    }
    /**
     * 发表评论
     * @return
     */
    @RequestMapping("/comment.do")
    public String comment(String userName, Integer articleId,String commentContent){
        articleService.comment(userName,articleId,commentContent);
        return "redirect:articleDetail.do?articleId="+articleId;
    }
    /**
     * 回复评论
     * @return
     */
    @RequestMapping("/reply.do")
    public String reply(String replyContent, Integer commentId,String userName,Integer articleId){
        articleService.reply(replyContent,commentId,userName);
        return "redirect:articleDetail.do?articleId="+articleId;

    }

}
