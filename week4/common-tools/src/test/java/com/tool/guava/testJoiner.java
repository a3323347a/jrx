package com.tool.guava;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testJoiner {

    /**
     * 测试使用Joiner使用&拼接map
     */
    @Test
    public void test1(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("pter", "aaa");
        map.put("cuige", "bbb");
        map.put("han", "ccc");
        // oiner.MapJoiner mapJoiner = Joiner.on("&").withKeyValueSeparator(":");
        Joiner joiner = Joiner.on("&");
        Joiner.MapJoiner mapJoiner = joiner.withKeyValueSeparator("=");
        System.out.println(mapJoiner.join(map));
        //输出：han=ccc&pter=aaa&cuige=bbb  在组装http参数的时候很有用
    }

    /**
     * 测试使用 = 拼接字符数组
     */
    @Test
    public void test2(){
        Joiner joiner = Joiner.on("==");
        String str[] = {"aaa", "vbbb", "ccc", "ddd"};
        System.out.println(joiner.join(str));
        //输出：aaa==vbbb==ccc==ddd
    }

    /**
     * 测试拼接stringBuilder和ArrayList字符list
     */
    @Test
    public void testAppendTo() {
        StringBuilder stringBuilder = new StringBuilder("peter_");
        ArrayList<String> strs = new ArrayList<>();
        strs.add("nantian");
        strs.add("zhikang");
        strs.add("qunar");
        Joiner joiner = Joiner.on("_");
        StringBuilder str1 = joiner.appendTo(stringBuilder, strs);
        System.out.println(str1.toString());
        //输出：peter_nantian_zhikang_qunar
    }

}
