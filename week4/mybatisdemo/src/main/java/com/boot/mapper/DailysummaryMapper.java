package com.boot.mapper;

import com.boot.model.Dailysummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailysummaryMapper {
    /**
     * 插入汇总信息
     * @param dailysummary
     */
    void insertDailysummary(Dailysummary dailysummary);

    /**
     * 查询汇总表记录数量
     * @return
     */
    int countByExample();

    /**
     * 根据索引项查询
     * @param Sindex
     * @return
     */
    Dailysummary selectBysIndex( String Sindex);

    /**
     * 根据索引项更新
     * @param dailysummary
     */
    void updateBysIndex( Dailysummary dailysummary);

    /**
     * 根据索引项删除
     * @param Sindex
     */
    void deleteBysIndex( String Sindex);

    /**
     * 根据客户id删除
     * @param custId
     */
    void deleteByCustId( Integer custId);

    /**
     * 查询全部
     * @return
     */
    List<Dailysummary> selectAll();

    /**
     * 根据客户ID来查询他的所有记录信息
     */
    List<Dailysummary> selectDailySummaryById(Integer id);
}