package com.tool.common_lang;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

/**
 * NumberUtils---字符串转数据或者判断字符串是否是数字常用工具类
 */
public class testNumberUtils {
    @Test
    public void test(){
        System.out.println(NumberUtils.isNumber("231232.8"));//true---判断是否是数字
        System.out.println(NumberUtils.isDigits("2312332.5"));//false，判断是否是整数
        System.out.println(NumberUtils.toDouble(null));//如果传的值不正确返回一个默认值，字符串转double，传的不正确会返回默认值
        System.out.println(NumberUtils.createBigDecimal("333333"));//字符串转bigdecimal
    }
}
