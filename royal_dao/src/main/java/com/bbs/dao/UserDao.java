package com.bbs.dao;


import com.bbs.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Select("select count(*) from bbs_user_table where userName=#{userName}")
    int findByName(String userName);


    @Insert("insert into bbs_user_table(userName,userPass,email) values(#{userName},#{userPass},#{email})")
    void register(User user);

    @Select("select * from bbs_user_table where userName=#{userName}")
    public User findRole(String userName);

    @Update("update bbs_user_table set email=#{email} where userName=#{userName}")
    void updateEmail(@Param("email") String email,@Param("userName") String userName);

    @Update("update bbs_user_table set userPass=#{newPassword} where userName=#{userName}")
    void UpdateUserPass(@Param("newPassword") String newPassword,@Param("userName") String userName);


    @Select("select * from bbs_user_table where userPass=#{oldPassword} and userName=#{userName}")
    User findOldUserPass(@Param("oldPassword") String oldPassword, @Param("userName") String userName);

    @Select("select * from bbs_user_table where email=#{email} and userName=#{userName}")
    User findNewEmail(@Param("email") String email, @Param("userName") String userName);

    @Update("update bbs_user_table set role=2 where userName=#{userName}")
    void updateUserRole(String userName);

    //查询用户名与密码，获取用户
    @Select("select * from bbs_user_table where userName = #{userName} and userPass = #{userPass}")
    User findByNameAndPass(@Param("userName") String userName, @Param("userPass") String userPass);


    //更新用户登录状态
    @Update("update bbs_user_table set loginStatus = #{status} where userName =#{userName}")
    void updateLoginStatus (@Param("userName")String userName,@Param("status") int status);

    /**
     * 查询后台所有用户和用户组信息进行分页查询
     * @return
     */
    @Select("select * from bbs_user_table")
    List<User> findAll(@Param("page") int page,@Param("size")int size);

    /**
     * 根据用户名和用户组模糊分页查询
     * @param username
     * @param role
     * @return
     */
    @Select("SELECT * FROM bbs_user_table WHERE userName LIKE #{username} and role LIKE #{role}")
    List<User> findByLike(@Param("page") int page,@Param("size") int size,@Param("username") String username,@Param("role") String role);

    /**
     * 分页查询所有用户信息
     * @param page
     * @param size
     * @param username
     * @param role
     * @return
     */
    @Select("select * from bbs_user_table")
    List<User> findAllUser(@Param("page") int page,@Param("size") int size,@Param("username")String username,@Param("role")String role);
}
