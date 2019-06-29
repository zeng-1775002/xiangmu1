package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WordDao {
    @Select("select * from bbs_word_table where status=1")
    List<Word> findAll();
    /**
     * 管理员禁用敏感
     * @param word
     * @return
     */
    @Update("update bbs_word_table set status=0 where word=#{word}")
    void ban(String word);
    /**
     * 管理员启用敏感
     * @param word
     * @return
     */
    @Update("update bbs_word_table set status=1 where word=#{word}")
    void open(String word);

    @Insert("insert into bbs_word_table(word,status) values(#{word},0)")
    void addWord(String word);

    @Select("select * from bbs_word_table")
    List<Word> findAllWord();
}
