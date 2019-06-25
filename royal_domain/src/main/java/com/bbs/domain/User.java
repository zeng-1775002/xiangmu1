package com.bbs.domain;

import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String userPass;
    private String email;


    //头像
    private String picUrl;

    //1代表普通用户；2代表高级用户，3代表超级管理员
    private int role;

    private String roleStr;

    private Date lastLoginTime;

    //登录状态，0代表未登录，1代表已登录
    private int loginStatus;

    //发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
    private int talkStatus;

    //申请升级(0-未申请,1-已申请)
    private int isupdating;

    //申请升级审核状态(0-未处理,1-已处理)
    private int updateStatus;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    //1代表普通用户；2代表高级用户，3代表超级管理员
    public String getRoleStr() {
        if (role == 1){
            roleStr ="普通用户";
        }
        if (role == 2){
            roleStr ="高级用户";
        }
        if (role == 3){
            roleStr ="超级管理员";
        }
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getTalkStatus() {
        return talkStatus;
    }

    public void setTalkStatus(int talkStatus) {
        this.talkStatus = talkStatus;
    }

    public int getIsupdating() {
        return isupdating;
    }

    public void setIsupdating(int isupdating) {
        this.isupdating = isupdating;
    }

    public int getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(int updateStatus) {
        this.updateStatus = updateStatus;
    }
}
