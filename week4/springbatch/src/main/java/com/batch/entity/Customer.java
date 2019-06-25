package com.batch.entity;

public class Customer {

    /**
     * 客户号
     */
    private int custid;
    /**
     * 客户姓名
     */
    private String surname;
    /**
     * 性别
     */
    private String gender;
    /**
     * 教育状况
     */
    private String educades;
    /**
     * 婚姻状况
     */
    private String mardes;
    /**
     * 年龄
     */
    private int age;
    /**
     * 地址
     */
    private String address;

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

    public Customer(int custid, String surname, String gender, String educades, String mardes, int age, String address) {
        this.custid = custid;
        this.surname = surname;
        this.gender = gender;
        this.educades = educades;
        this.mardes = mardes;
        this.age = age;
        this.address = address;
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
                '}';
    }
}
