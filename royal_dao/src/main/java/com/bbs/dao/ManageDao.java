package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ManageDao {

    /**
     * 根据用户名和密码进行查询管理员
     * @param username
     * @return
     */
    @Select("select * from bbs_user_table where userName = #{username}")
    User findByManage(@Param("username") String username);
}
