package com.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String name;
    private int age;
    private String[] hobby;
    private ArrayList<Course> courses;

    public User() {
    }

    public User(String name, int age, String[] hobby, ArrayList<Course> courses) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", courses=" + courses +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
