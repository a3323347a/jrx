package com.tool.common_lang;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.Map;

/**
 * 测试ArrayUtils的常用方法
 */
public class testArrayUtils {

    @Test
    public void test(){

        // 定义数据
        int[] intArray1 = { 2, 4, 8, 16 };
        int[][] intArray2 = { { 1, 2 }, { 2, 4 }, { 3, 8 }, { 4, 16 } };
        Object[][] notAMap = {
                { "A", new Double(100) },
                { "B", new Double(80) },
                { "C", new Double(60) },
                { "D", new Double(40) },
                { "E", new Double(20) }
        };
        // 输出数组
        System.out.println("intArray1: " + ArrayUtils.toString(intArray1));
        System.out.println("intArray2: " + ArrayUtils.toString(intArray2));
        System.out.println("notAMap: " + ArrayUtils.toString(notAMap));
        // 根据下标查询
        System.out.println("intArray1 contains '8'? "
                + ArrayUtils.contains(intArray1, 8));
        System.out.println("intArray1 index of '8'? "
                + ArrayUtils.indexOf(intArray1, 8));
        System.out.println("intArray1 last index of '8'? "
                + ArrayUtils.lastIndexOf(intArray1, 8));
        // 复制和转置
        int[] intArray3 = ArrayUtils.clone(intArray1);
        System.out.println("intArray3: " + ArrayUtils.toString(intArray3));
        ArrayUtils.reverse(intArray3);
        System.out.println("intArray3 reversed: "
                + ArrayUtils.toString(intArray3));
        // Object类型和String类型转换
        Integer[] integerArray1 = ArrayUtils.toObject(intArray1);
        System.out.println("integerArray1: "
                + ArrayUtils.toString(integerArray1));
        // 转换成Map类型
        Map map = ArrayUtils.toMap(notAMap);
        Double res = (Double) map.get("C");
        System.out.println("get 'C' from map: " + res);

    }

}
