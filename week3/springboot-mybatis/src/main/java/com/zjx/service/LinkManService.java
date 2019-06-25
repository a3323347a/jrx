package com.zjx.service;

import com.zjx.entity.LinkMan;
import com.zjx.mapper.LinkManMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@MapperScan("com.zjx.mapper")
public class LinkManService {

    @Autowired
    private LinkManMapper linkManMapper;

    @Transactional(rollbackFor = Exception.class)
    public void deleteLinkMan(Long id){
        linkManMapper.deleteLinkManById(id);
    }

    public LinkMan getLinkManById(Long id){
        return linkManMapper.getLinkManById(id);
    }

    public LinkMan getLinkManBylkmcustId(Long id){return linkManMapper.getLinkManBylkmcustId(id);}

    public void deleteLinkManBylkmcustId(Long id){
        linkManMapper.deleteBylkmcustId(id);
    }
}
