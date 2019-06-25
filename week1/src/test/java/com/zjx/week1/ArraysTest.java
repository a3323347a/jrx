package com.zjx.week1;

import com.zjx.entity.Person;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试Arrays的用法
 */
public class ArraysTest {

    /**
     * 重写了person的compareTo方法，实现了按照年龄升序排序
     */
    @Test
    public void testSort(){
        Person[] persons = new Person[3];
        persons[0] = new Person("tom",35);
        persons[1] = new Person("jack",25);
        persons[2] = new Person("cjx",45);

        Arrays.sort(persons);
        for (Person p:persons){
            System.out.println(p);
        }
    }
    /**
     * 使用自定义比较器，对数组元素进行排序（串行排序）
     */
    @Test
    public void test1(){
        String[] data = {"1", "4", "3", "2"};
        System.out.println(Arrays.toString(data)); // [1, 4, 3, 2]
        // 实现降序排序，返回-1放左边，1放右边，0保持不变
        Arrays.sort(data, (str1, str2) -> {
            if (str1.compareTo(str2) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(Arrays.toString(data));// [4, 3, 2, 1]
    }

    /**
     * 使用自定义比较器，对数组元素的指定范围进行排序（串行排序）
     */
    @Test
    public void test2(){
        String[] data = {"1", "4", "3", "2"};
        System.out.println(Arrays.toString(data)); // [1, 4, 3, 2]
        // 对下标[0, 3)的元素进行降序排序，即对1，4，3进行降序排序，2保持不变
        Arrays.sort(data, 0, 3, (str1, str2) -> {
            if (str1.compareTo(str2) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(Arrays.toString(data));// [1, 3, 4, 2]
    }
}
