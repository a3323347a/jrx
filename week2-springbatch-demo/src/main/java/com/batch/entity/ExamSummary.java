package com.batch.entity;

public class ExamSummary {
    /**
     * 学生id
     */
    private int id;
    /**
     * 考试序号
     */
    private String examnumber;
    /**
     * 总成绩
     */
    private int totalpoint;
    /**
     * 平均成绩
     */
    private double averagescore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamnumber() {
        return examnumber;
    }

    public void setExamnumber(String examnumber) {
        this.examnumber = examnumber;
    }

    public int getTotalpoint() {
        return totalpoint;
    }

    public void setTotalpoint(int totalpoint) {
        this.totalpoint = totalpoint;
    }

    public double getAveragescore() {
        return averagescore;
    }

    public void setAveragescore(double averagescore) {
        this.averagescore = averagescore;
    }

    @Override
    public String toString() {
        return "ExamSummary{" +
                "id=" + id +
                ", examnumber='" + examnumber + '\'' +
                ", totalpoint=" + totalpoint +
                ", averagescore=" + averagescore +
                '}';
    }
}
