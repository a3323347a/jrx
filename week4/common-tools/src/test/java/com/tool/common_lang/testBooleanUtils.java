package com.tool.common_lang;

import org.apache.commons.lang.BooleanUtils;
import org.junit.Test;

/**
 * BooleanUtils---判断Boolean类型工具类
 */
public class testBooleanUtils {

    @Test
    public void test() {
        System.out.println(BooleanUtils.isFalse(true));//false
        System.out.println(BooleanUtils.toBoolean("yes"));//true
        System.out.println(BooleanUtils.toBooleanObject(0));//false
        System.out.println(BooleanUtils.toStringYesNo(false));//no
        //true-----第一个参数是需要验证的字符串，
        // 第二个是返回true的值，第三个是返回false的值，第四个是返回null的值
        System.out.println(BooleanUtils.toBooleanObject("ok", "ok", "error", "null"));
    }
}

