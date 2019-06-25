package com.batch.entity;


/**
 * 考试详细表
 */
public class ExamDetail {
    /**
     * 学生id
     */
    private int id;

    /**
     * 数学成绩
     */
    private int math;
    /**
     * 语文成绩
     */
    private int chinese;
    /**
     * 英语成绩
     */
    private int english;
    /**
     * 考试序号
     */
    private String examnumber;
    /**
     * 考试时间
     */
    private String examtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public String getExamnumber() {
        return examnumber;
    }

    public void setExamnumber(String examnumber) {
        this.examnumber = examnumber;
    }

    public String getExamtime() {
        return examtime;
    }

    public void setExamtime(String examtime) {
        this.examtime = examtime;
    }

    @Override
    public String toString() {
        return "ExamDetail{" +
                "id=" + id +
                ", math=" + math +
                ", chinese=" + chinese +
                ", english=" + english +
                ", examnumber='" + examnumber + '\'' +
                ", examtime=" + examtime +
                '}';
    }
}
