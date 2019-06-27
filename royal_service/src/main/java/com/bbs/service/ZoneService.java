package com.bbs.service;

import com.bbs.domain.ZoneApplyTable;
import com.bbs.domain.ZoneTable;

import java.util.List;

public interface ZoneService {
    public void insertNewZone(String zoneName,String reason,String userName);

    List<ZoneApplyTable> findAllZoneApply();

    void updateStatus(String zoneName,String userName,int status);

    void addNewZone(String zoneName, int isDef);

    List<ZoneTable> findNewZone();
}
