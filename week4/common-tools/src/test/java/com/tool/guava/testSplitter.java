package com.tool.guava;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;


/**
 * 测试拆分器 Splitter
 */
public class testSplitter {
    @Test
    public void test(){
        //1．拆分字符串为List集合
        Splitter splitter =Splitter.on(",");
        String str1="a,b,c,d,e,f,g";
        List<String> list1=splitter.splitToList(str1);
        System.out.println(list1);

        //2.忽略空字符
        splitter =Splitter.on(",").omitEmptyStrings();
        String str2="a,b,c,d,,f,g";
        List<String> list2=splitter.splitToList(str2);
        System.out.println(list2);

        //3.忽略空字符且去除字符串前后空格
        splitter =Splitter.on(",").omitEmptyStrings().trimResults();
        String str3="a,b,c,d,,f,  g  ";
        List<String> list3=splitter.splitToList(str3);
        System.out.println(list3);
    }

}
