package com.bbs.service.impl;

import com.bbs.dao.PostManageDao;
import com.bbs.domain.Article;
import com.bbs.service.PostManageService;
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
public class PostManageServiceImpl implements PostManageService{

    @Autowired
    private PostManageDao postManageDao;

    @Override
    public List<Article> findByLike(String title, String sendername) {
        return postManageDao.findByLike(title,sendername);
    }
}
