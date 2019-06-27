package com.bbs.service.impl;

import com.bbs.dao.ZoneDao;
import com.bbs.domain.ZoneApplyTable;
import com.bbs.domain.ZoneTable;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    private ZoneDao zoneDao;


    @Override
    public void insertNewZone(String zoneName, String reason,String userName) {
        zoneDao.insertNewZone(zoneName,reason,userName);
    }

    @Override
    public List<ZoneApplyTable> findAllZoneApply() {
        return zoneDao.findAllZoneApply();
    }

    @Override
    public void updateStatus(String zoneName, String userName, int status) {
        zoneDao.updateStatus(zoneName, userName, status);
    }

    @Override
    public void addNewZone(String zoneName, int isDef) {
        zoneDao.addNewZone(zoneName, isDef);
    }

    @Override
    public List<ZoneTable> findNewZone() {
        return zoneDao.findNewZone();
    }

}

