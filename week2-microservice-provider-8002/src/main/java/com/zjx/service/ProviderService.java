package com.zjx.service;

import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    public String add() {
        return "添加单个商品，由8002提供服务";
    }

    public String get() {
        return "获得单个商品，由8002提供服务";
    }

    public String list() {
        return "获取全部商品，由8002提供服务";
    }
}
