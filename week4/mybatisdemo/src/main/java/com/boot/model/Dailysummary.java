package com.boot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
@ApiModel
public class Dailysummary {
    /**
     * 索引项
     */
    @ApiModelProperty
    private String sIndex;
    /**
     * 客户ID
     */
    @ApiModelProperty
    private Integer custId;
    /**
     * 更新时间
     */
    @ApiModelProperty
    private Date updateTime;

    /**
     * 交易日期
     */
    private Date transDate;
    /**
     * 客户名字
     */
    @ApiModelProperty
    private String surname;
    /**
     * 最大交易金额
     */
    @ApiModelProperty
    private BigDecimal tranMaxAmt;
    /**
     * 当天还款总额
     */
    private BigDecimal payAmt;
    /**
     * 消费笔数
     */
    @ApiModelProperty
    private Integer tranCnt;
    /**
     * 还款笔数
     */
    @ApiModelProperty
    private Integer payCnt;
    /**
     * 当天消费总额
     */
    @ApiModelProperty
    private BigDecimal tranAmt;

    public String getsIndex() {
        return sIndex;
    }

    public void setsIndex(String sIndex) {
        this.sIndex = sIndex == null ? null : sIndex.trim();
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname == null ? null : surname.trim();
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

    public Integer getTranCnt() {
        return tranCnt;
    }

    public void setTranCnt(Integer tranCnt) {
        this.tranCnt = tranCnt;
    }

    public Integer getPayCnt() {
        return payCnt;
    }

    public void setPayCnt(Integer payCnt) {
        this.payCnt = payCnt;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public Dailysummary(String sIndex, Integer custId, Date updateTime, Date transDate, String surname, BigDecimal tranMaxAmt, BigDecimal payAmt, Integer tranCnt, Integer payCnt, BigDecimal tranAmt) {
        this.sIndex = sIndex;
        this.custId = custId;
        this.updateTime = updateTime;
        this.transDate = transDate;
        this.surname = surname;
        this.tranMaxAmt = tranMaxAmt;
        this.payAmt = payAmt;
        this.tranCnt = tranCnt;
        this.payCnt = payCnt;
        this.tranAmt = tranAmt;
    }
    public Dailysummary(){

    }

    @Override
    public String toString() {
        return "Dailysummary{" +
                "sIndex='" + sIndex + '\'' +
                ", custId=" + custId +
                ", updateTime=" + updateTime +
                ", transDate=" + transDate +
                ", surname='" + surname + '\'' +
                ", tranMaxAmt=" + tranMaxAmt +
                ", payAmt=" + payAmt +
                ", tranCnt=" + tranCnt +
                ", payCnt=" + payCnt +
                ", tranAmt=" + tranAmt +
                '}';
    }
}