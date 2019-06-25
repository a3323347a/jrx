package com.boot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;
@ApiModel
public class Customer {
    /**
     * 客户号
     */
    @ApiModelProperty
    private int custid;
    /**
     * 客户姓名
     */
    @ApiModelProperty
    private String surname;
    /**
     * 性别
     */
    @ApiModelProperty
    private String gender;
    /**
     * 教育状况
     */
    private String educades;
    /**
     * 婚姻状况
     */
    @ApiModelProperty
    private String mardes;
    /**
     * 年龄
     */
    @ApiModelProperty
    private int age;
    /**
     * 地址
     */
    @ApiModelProperty
    private String address;
    /**
     * 一对多，一个客户对应多条交易明细订单
     */
    @ApiModelProperty
    private Set<TransDetail> linkTransDetails = new HashSet<>();

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducades() {
        return educades;
    }

    public void setEducades(String educa_des) {
        this.educades = educa_des;
    }

    public String getMardes() {
        return mardes;
    }

    public void setMardes(String mar_des) {
        this.mardes = mar_des;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<TransDetail> getLinkTransDetails() {
        return linkTransDetails;
    }

    public void setLinkTransDetails(Set<TransDetail> linkTransDetails) {
        this.linkTransDetails = linkTransDetails;
    }

    public Customer(int custid, String surname, String gender, String educades, String mardes, int age, String address, Set<TransDetail> linkTransDetails) {
        this.custid = custid;
        this.surname = surname;
        this.gender = gender;
        this.educades = educades;
        this.mardes = mardes;
        this.age = age;
        this.address = address;
        this.linkTransDetails = linkTransDetails;
    }

    public Customer(){

    }

    @Override
    public String toString() {
        return "Customer{" +
                "custid=" + custid +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", educades='" + educades + '\'' +
                ", mardes='" + mardes + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", linkTransDetails=" + linkTransDetails +
                '}';
    }
}
