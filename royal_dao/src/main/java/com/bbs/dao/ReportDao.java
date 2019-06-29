package com.bbs.dao;

import com.bbs.domain.Report;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ReportDao {
    //添加举报内容
    @Insert("insert into bbs_report_table(reportId,reportContent,reportTime,reportUserName,reportStatus,articleId) values(#{reportId},#{reportContent},#{reportTime},#{reportUserName},#{reportStatus},#{articleId})")
    void saveReport(Report report);

    /**
     * 分页查询所有举报
     * @param page
     * @param size
     * @return
     */
    @Select("select * from bbs_report_table")
    List<Report> findAll(@Param("page") int page, @Param("size") int size);


    //屏蔽 处理状态为1
    @Update("update bbs_report_table set reportStatus = 1 where reportId = #{reportId}")
    void updateReport(String articleId);
    //驳回 处理状态为0
    @Update("update bbs_report_table set reportStatus = 0 where reportId = #{reportId}")
    void updateReports(String articleId);
}
