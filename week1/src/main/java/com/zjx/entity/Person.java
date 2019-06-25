package com.zjx.entity;

public class Person implements Comparable{

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     *  当向TreeSet中添加Person类的对象，依据此方法按照某个属性排序
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person p = (Person)o;
            //按照name属性排序
            //return this.name.compareTo(p.name);

            // 按照age属性排序
            return this.age.compareTo(p.age);
        }
        return 0;
    }
}
