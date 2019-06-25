package com.tool.common_lang;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * 测试StringUtils的常用方法
 */
public class testStringUtils {

    @Test
    public void test(){

        String str1 = "";

        String str2 = " ";

        String str3 = "/t";

        String str4 = null;

        String str5 = "123";

        String str6 = "ABCDEFG";

        String str7 = "It feels good to use Jakarta Commons./r/n";


        // check for empty strings

        System.out.println("==============================");

        System.out.println("Is str1 blank? " + StringUtils.isBlank(str1));

        System.out.println("Is str2 blank? " + StringUtils.isBlank(str2));

        System.out.println("Is str3 blank? " + StringUtils.isBlank(str3));

        System.out.println("Is str4 blank? " + StringUtils.isBlank(str4));


        //判断是否是numerics类型
        System.out.println("==============================");
        System.out.println("Is str5 numeric? " + StringUtils.isNumeric(str5));
        System.out.println("Is str6 numeric? " + StringUtils.isNumeric(str6));
        // 测试转换字符
        System.out.println("==============================");
        System.out.println("str6: " + str6);
        System.out.println("str6 reversed: " + StringUtils.reverse(str6));
        System.out.println("str7: " + str7);
        String str8 = StringUtils.chomp(str7);
        str8 = StringUtils.reverseDelimited(str8, ' ');
        System.out.println("str7 reversed whole words : /r/n" + str8);
        //测试repeat、center、join
        System.out.println("==============================");
        System.out.println("print header:");
        String padding = StringUtils.repeat("=", 50);
        String msg = StringUtils.center(" Customised Header ", 50, "%");
        Object[] raw = new Object[]{padding, msg, padding};
        String header = StringUtils.join(raw, "/r/n");
        System.out.println(header);
    }
}
