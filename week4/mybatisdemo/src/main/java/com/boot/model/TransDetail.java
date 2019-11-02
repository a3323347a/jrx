package com.boot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
@ApiModel
public class TransDetail {
    /**
     * 交易id
     */
    @ApiModelProperty
    private int transId;
    /**
     * 客户号
     */
    @ApiModelProperty
    private int custId;
    /**
     * 账户号
     */
    @ApiModelProperty
    private String account;
    /**
     * 卡号
     */
    @ApiModelProperty
    private String cardnbr;
    /**
     * 交易流水号
     */
    @ApiModelProperty
    private String tranno;
    /**
     * 账单月
     */
    @ApiModelProperty
    private int monthnbr;
    /**
     * 交易金额
     */
    @ApiModelProperty
    private BigDecimal bill;
    /**
     * 交易类型
     */
    @ApiModelProperty
    private String transtype;
    /**
     * 交易具体时间
     */
    @ApiModelProperty
    private String txndatetime;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCardnbr() {
        return cardnbr;
    }

    public void setCardnbr(String cardnbr) {
        this.cardnbr = cardnbr;
    }

    public String getTranno() {
        return tranno;
    }

    public void setTranno(String tranno) {
        this.tranno = tranno;
    }

    public int getMonthnbr() {
        return monthnbr;
    }

    public void setMonthnbr(int monthnbr) {
        this.monthnbr = monthnbr;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getTxndatetime() {
        return txndatetime;
    }

    public void setTxndatetime(String txndatetime) {
        this.txndatetime = txndatetime;
    }

    public TransDetail(int transId, int custId, String account, String cardnbr, String tranno, int monthnbr, BigDecimal bill, String transtype, String txndatetime) {
        this.transId = transId;
        this.custId = custId;
        this.account = account;
        this.cardnbr = cardnbr;
        this.tranno = tranno;
        this.monthnbr = monthnbr;
        this.bill = bill;
        this.transtype = transtype;
        this.txndatetime = txndatetime;
    }
    public TransDetail(){

    }
    @Override
    public String toString() {
        return "TransDetail{" +
                "transId=" + transId +
                ", custId=" + custId +
                ", account='" + account + '\'' +
                ", cardnbr='" + cardnbr + '\'' +
                ", tranno=" + tranno +
                ", monthnbr=" + monthnbr +
                ", bill=" + bill +
                ", transtype='" + transtype + '\'' +
                ", txndatetime=" + txndatetime +
                '}';
    }
}