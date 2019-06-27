package com.bbs.service.impl;

import com.bbs.dao.PageManageDao;
import com.bbs.domain.Article;
import com.bbs.service.PageManageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Lyq
 * @Profession Programmer
 */
@Service
@Transactional
public class PageManageServiceImpl implements PageManageService{

    @Autowired
    private PageManageDao pageManageDao;

    @Override
    public List<Article> findAll(int page, int size) {
        //利用pageHelper进行分页查询
        PageHelper.startPage(page,size);
        return pageManageDao.findAll(page,size);
    }
    //置顶
    @Override
    public void updateIsTop(String articleId) {
        pageManageDao.updateIsTop(articleId);
    }
    //取消
    @Override
    public void updateIsTops(String articleId) {
        pageManageDao.updateIsTops(articleId);
    }
}
