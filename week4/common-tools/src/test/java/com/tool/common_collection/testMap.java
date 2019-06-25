package com.tool.common_collection;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;


/**
 *  所谓BidiMap，直译就是双向Map，可以通过key找到value
 *  所谓MultiMap 就是说一个key不在是简单的指向一个对象，而是一组对象
 */
public class testMap {

    /**
     * 测试BidiMap,通过key找到value,通过value找到key
     */
    @Test
    public void test1(){
        System.out.println(StringUtils.center(" demoBidiMap ", 40, "="));
        BidiMap bidiMap = new DualHashBidiMap();
        bidiMap.put("BJ", "Beijing");
        bidiMap.put("SH", "Shanghai");
        bidiMap.put("GZ", "Guangzhou");
        bidiMap.put("CD", "Chengdu");
        System.out.println("Key-Value: BJ = " + bidiMap.get("BJ"));
        System.out.println("Value-Key: Chengdu = " + bidiMap.getKey("Chengdu"));
        System.out.println(StringUtils.repeat("=", 40));
    }

    /**
     * 测试MultiMap
     */
    @Test
    public void test2(){
        System.out.println(StringUtils.center(" demoMultiMap ", 40, "="));
        MultiMap multiMap = new MultiHashMap();
        multiMap.put("Sean", "C/C++");
        multiMap.put("Sean", "OO");
        multiMap.put("Sean", "Java");
        multiMap.put("Sean", ".NET");
        multiMap.remove("Sean", "C/C++");
        System.out.println("Sean's skill set: " + multiMap.get("Sean"));
        System.out.println(StringUtils.repeat("=", 40));
    }

}
