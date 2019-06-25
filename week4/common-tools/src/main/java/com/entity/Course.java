package com.entity;

public class Course {
    private String math;

    public Course() {
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Course{" +
                "math='" + math + '\'' +
                '}';
    }
}

