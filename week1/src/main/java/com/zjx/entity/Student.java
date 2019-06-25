package com.zjx.entity;

public class Student implements Comparable{

    private Integer id;
    private String name;
    private int score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(Integer id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            Student s = (Student) o;
            //按照name属性排序
            return this.name.compareTo(s.name);
        }
        return 0;
    }
}
