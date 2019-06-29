package com.bbs.service;

import com.bbs.domain.Word;

import java.util.List;

public interface WordService {
    List<Word> findAll();

    void ban(String word);

    void open(String word);

    void addWord(String word);

    List<Word> findAllWord();
}
