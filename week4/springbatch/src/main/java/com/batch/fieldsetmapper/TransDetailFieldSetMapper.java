package com.batch.fieldsetmapper;

import com.batch.entity.TransDetail;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * 将文件记录映射成交易明细类
 */
public class TransDetailFieldSetMapper implements FieldSetMapper<TransDetail> {

    @Override
    public TransDetail mapFieldSet(FieldSet fieldSet) throws BindException {
        TransDetail transDetail = new TransDetail();
        transDetail.setTransId(fieldSet.readInt("transId"));
        transDetail.setCustId(fieldSet.readInt("custId"));
        transDetail.setAccount(fieldSet.readString("account"));
        transDetail.setCardnbr(fieldSet.readString("cardnbr"));
        transDetail.setTranno(fieldSet.readString("tranno"));
        transDetail.setMonthnbr(fieldSet.readInt("monthnbr"));
        transDetail.setBill(fieldSet.readBigDecimal("bill"));
        transDetail.setTranstype(fieldSet.readString("transtype"));
        transDetail.setTxndatetime(fieldSet.readString("txndatetime"));
        return transDetail;
    }
}
