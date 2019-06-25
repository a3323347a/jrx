package com.tool.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class testPreconditions {

    /**
     * 测试使用Preconditions对参数进行预判断和处理
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        getPersonByPrecondition(8,"peida");

        try {
            getPersonByPrecondition(-9,"peida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getPersonByPrecondition(int age,String name)throws Exception{
        Preconditions.checkNotNull(name, "name为null");
        Preconditions.checkArgument(name.length()>0, "name为\'\'");
        Preconditions.checkArgument(age>0, "age 必须大于0");
        System.out.println("a person age:"+age+",name:"+name);
    }
}
