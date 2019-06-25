package com.boot.service;

import com.boot.mapper.TransdetailsMapper;
import com.boot.model.TransDetail;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@MapperScan("com.boot.mapper")
public class TransDetailService {

    @Autowired
    private TransdetailsMapper transdetailsMapper;

    public TransDetail getTransDetailById(Integer id){return transdetailsMapper.selectById(id);}

    public int getCount(){return transdetailsMapper.countByExample();}

    public void deleteTransDetailById(Integer id){transdetailsMapper.deleteById(id);}

    public void addTransDetail(TransDetail transDetail){transdetailsMapper.insertTransDetail(transDetail);}

    public void updateTransDetail(TransDetail transDetail){transdetailsMapper.updateByPrimaryKeySelective(transDetail);}

    public List<TransDetail> getAllTransDetail(){return transdetailsMapper.getAllTransDetail();}
}
