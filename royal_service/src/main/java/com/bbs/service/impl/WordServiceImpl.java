package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.domain.Word;
import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;

    @Override
    public List<Word> findAll() {
        return wordDao.findAll();
    }
    /**
     * 管理员禁用敏感
     * @param word
     * @return
     */
    @Override
    public void ban(String word) {
        wordDao.ban(word);
    }
    /**
     * 管理员启用敏感
     * @param word
     * @return
     */
    @Override
    public void open(String word) {
        wordDao.open(word);
    }
    /**
     * 管理员添加敏感
     * @param word
     * @return
     */
    @Override
    public void addWord(String word) {
        wordDao.addWord(word);
    }

    @Override
    public List<Word> findAllWord() {
        return wordDao.findAllWord();
    }
}
