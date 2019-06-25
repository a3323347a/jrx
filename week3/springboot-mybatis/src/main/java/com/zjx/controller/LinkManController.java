package com.zjx.controller;

import com.zjx.entity.LinkMan;
import com.zjx.service.LinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkManController {


    @Autowired
    private LinkManService linkManService;

    @GetMapping("/linkman/get/{id}")
    public LinkMan getLinkMan(@PathVariable("id") Long id){
        return linkManService.getLinkManById(id);
    }

    @GetMapping("/linkman/delete/{id}")
    public void deleteLinkMan(@PathVariable("id") Long id){
        linkManService.deleteLinkMan(id);
    }
}
