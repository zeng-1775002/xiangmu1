package com.bbs.dao;

import com.bbs.domain.ZoneApplyTable;
import com.bbs.domain.ZoneTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ZoneDao {

    //申请新版块
    @Insert("INSERT INTO bbs_zoneapply_table (zoneName,userName,reason) VALUES(#{zoneName},#{reason},#{userName}) ")
    public void insertNewZone(@Param("zoneName") String zoneName,
                              @Param("reason")String reason,
                              @Param("userName")String userName);

    //查询所有申请的版块
    @Select("select * from bbs_zoneapply_table")
    List<ZoneApplyTable> findAllZoneApply();

    //更新版块status申请结果
    @Update("update bbs_zoneapply_table set status =#{status} where zoneName=#{zoneName} and userName=#{userName}")
    void updateStatus(@Param("zoneName") String zoneName,@Param("userName") String userName,@Param("status") int status);


    //新增版块
    @Insert("INSERT INTO bbs_zone_table (zoneName,isDef) VALUES(#{zoneName},#{isDef})")
    void addNewZone(@Param("zoneName") String zoneName, @Param("isDef")int isDef);

    //首页展示新版块
    @Select("select * from bbs_zone_table where zoneId > 4")
    List<ZoneTable> findNewZone();
}
