package com.batch.databasetodatabase;

import com.batch.entity.ExamSummary;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 设置插入语句的Sql参数
 */
public class ExamSummaryItemPreparedStatementSetter implements ItemPreparedStatementSetter<ExamSummary> {

    @Override
    public void setValues(ExamSummary examSummary, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,examSummary.getId());
        preparedStatement.setString(2,examSummary.getExamnumber());
        preparedStatement.setDouble(3,examSummary.getTotalpoint());
        preparedStatement.setDouble(4,examSummary.getAveragescore());
    }
}
