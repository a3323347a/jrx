package com.zjx.mapper;

import com.zjx.entity.LinkMan;

public interface LinkManMapper {

    LinkMan getLinkManById(Long id);
    void addLinkMan(LinkMan linkMan);
    LinkMan updateLinkMan(LinkMan linkMan);
    void deleteLinkManById(Long id);
    LinkMan getLinkManBylkmcustId(Long id);
    void deleteBylkmcustId(Long id);
}
