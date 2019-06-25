package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {
    @Select("select * from bbs_user_table where userName = #{userName} and userPass = #{userPass}")
    User findByNameAndPass(@Param("userName") String userName, @Param("userPass") String userPass);


    @Update("update bbs_user_table set loginStatus = #{status} where userName =#{userName}")
    void updateLoginStatus (@Param("userName")String userName,@Param("status") int status);
}
