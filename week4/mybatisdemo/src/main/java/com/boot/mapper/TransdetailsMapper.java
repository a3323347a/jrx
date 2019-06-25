package com.boot.mapper;

import com.boot.model.TransDetail;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransdetailsMapper {
    /**
     * 根据交易单号来查询
     * @param id
     * @return
     */
    TransDetail selectById( Integer id);

    /**
     * 查询交易明细的记录数量
     * @return
     */
    int countByExample();

    /**
     * 根据id删除
     * @param id
     */
    void deleteById( Integer id);

    /**
     * 添加交易明细表
     * @param transDetail
     */
    void insertTransDetail( TransDetail transDetail);

    /**
     * 根据transDetail的id来更新交易明细表信息
     * @param transDetail
     */
    void updateByPrimaryKeySelective( TransDetail transDetail);

    /**
     * 返回所有交易记录
     * @return
     */
    List<TransDetail> getAllTransDetail();
}