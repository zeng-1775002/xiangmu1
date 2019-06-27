package com.bbs.domain;

public class ZoneApplyTable {
    private int applyZoneId;
    private String zoneName;
    private String userName;
    private String reason;
    private int status;

    public int getApplyZoneId() {
        return applyZoneId;
    }

    public void setApplyZoneId(int applyZoneId) {
        this.applyZoneId = applyZoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
