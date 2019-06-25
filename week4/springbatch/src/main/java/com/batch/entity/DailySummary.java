package com.batch.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DailySummary {
    /**
     * 索引项
     */
    private String sindex;
    /**
     * 客户号
     */
    private int custId;
    /**
     * 更新时间
     */
    private  String datetime;
    /**
     * 日期
     */
    private Date date;
    /**
     * 客户姓名
     */
    private String custName;
    /**
     * 最大单笔交易金额
     */
    private BigDecimal tranMaxAmt;
    /**
     * 当天还款总额
     */
    private BigDecimal payAmt;
    /**
     * 当天消费笔数
     */
    private int tranCnt;
    /**
     * 当天还款笔数
     */
    private int payCnt;
    /**
     * 当天交易总金额
     */
    private BigDecimal tranAmt;

    public String getSindex() {
        return sindex;
    }

    public void setSindex(String sindex) {
        this.sindex = sindex;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public BigDecimal getTranMaxAmt() {
        return tranMaxAmt;
    }

    public void setTranMaxAmt(BigDecimal tranMaxAmt) {
        this.tranMaxAmt = tranMaxAmt;
    }

    public BigDecimal getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    public int getTranCnt() {
        return tranCnt;
    }

    public void setTranCnt(int tranCnt) {
        this.tranCnt = tranCnt;
    }

    public int getPayCnt() {
        return payCnt;
    }

    public void setPayCnt(int payCnt) {
        this.payCnt = payCnt;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public DailySummary(String sindex, int custId, String datetime, Date date, String custName, BigDecimal tranMaxAmt, BigDecimal payAmt, int tranCnt, int payCnt, BigDecimal tranAmt) {
        this.sindex = sindex;
        this.custId = custId;
        this.datetime = datetime;
        this.date = date;
        this.custName = custName;
        this.tranMaxAmt = tranMaxAmt;
        this.payAmt = payAmt;
        this.tranCnt = tranCnt;
        this.payCnt = payCnt;
        this.tranAmt = tranAmt;
    }
    public DailySummary(){

    }

    @Override
    public String toString() {
        return "DailySummary{" +
                "sindex='" + sindex + '\'' +
                ", custId=" + custId +
                ", datetime='" + datetime + '\'' +
                ", date=" + date +
                ", custName='" + custName + '\'' +
                ", tranMaxAmt=" + tranMaxAmt +
                ", payAmt=" + payAmt +
                ", tranCnt=" + tranCnt +
                ", payCnt=" + payCnt +
                ", tranAmt=" + tranAmt +
                '}';
    }
}
