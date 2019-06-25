package com.boot.service;

import com.boot.mapper.DailysummaryMapper;
import com.boot.model.Dailysummary;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@MapperScan("com.boot.mapper")
public class DailySummaryService {

    @Autowired
    private DailysummaryMapper dailysummaryMapper;

    public void addDailysummary(Dailysummary dailysummary){dailysummaryMapper.insertDailysummary(dailysummary);}

    public int getNumber(){return dailysummaryMapper.countByExample();}

    public Dailysummary getDailysummaryBysIndex(String sIndex){return dailysummaryMapper.selectBysIndex(sIndex);}

    public void updateDailysummaryBysIndex(Dailysummary dailysummary){dailysummaryMapper.updateBysIndex(dailysummary);}

    public void deleteDailysummaryBySindex(String sindex){dailysummaryMapper.deleteBysIndex(sindex);}

    public void deleteByCustId(Integer custId){dailysummaryMapper.deleteByCustId(custId);}

    public List<Dailysummary> selectAll(){return dailysummaryMapper.selectAll();}

    public List<Dailysummary> selectById(Integer id){return dailysummaryMapper.selectDailySummaryById(id);}
}
