package com.batch.fieldsetmapper;

import com.batch.entity.DailySummary;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库记录映射成实体类
 */
public class DailySummaryRowMapper implements RowMapper<DailySummary> {
    @Override
    public DailySummary mapRow(ResultSet resultSet, int i) throws SQLException {
        DailySummary dailySummary = new DailySummary();
        dailySummary.setSindex(null);
        dailySummary.setCustId(resultSet.getInt("cust_id"));
        dailySummary.setDatetime(resultSet.getString("update_time"));
        dailySummary.setDate(null);
        dailySummary.setCustName(resultSet.getString("surname"));
        dailySummary.setTranMaxAmt(resultSet.getBigDecimal("tran_max_amt"));
        dailySummary.setPayAmt(resultSet.getBigDecimal("pay_amt"));
        dailySummary.setPayCnt(resultSet.getInt("pay_cnt"));
        dailySummary.setTranCnt(resultSet.getInt("tran_cnt"));
        dailySummary.setTranAmt(resultSet.getBigDecimal("tran_amt"));
        return dailySummary;
    }
}
