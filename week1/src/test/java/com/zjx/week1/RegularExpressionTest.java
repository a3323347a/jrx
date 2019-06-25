package com.zjx.week1;

import org.junit.Test;

/**
 * 测试常用的正则表达式，如身份证、邮箱、手机号码、密码强度
 */

public class RegularExpressionTest {

    /*
     * 测试18位身份证的正则表达式
     */
    @Test
    public void IdCardTest(){
        /*
            [1-9] 第一位1-9中的一个      4
            \\d{5} 五位数字           10001（前六位省市县地区）
             (18|19|20)              19（现阶段可能取值范围18xx-20xx年）
             \\d{2}                    91（年份）
             ((0[1-9])|(10|11|12))     01（月份）
             (([0-2][1-9])|10|20|30|31)01（日期）
             \\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
             [0-9X] 0123456789X其中的一个 X（第十八位为校验值）
             $结尾
         */
        String regex = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))" +
                "(([0-2][1-9])|10|20|30|31)\\d{3}[0-9X]$";

        String[] IdCrad ={"11010219880215789X","01010219880215789X"};

        for (int i =0;i<IdCrad.length;i++) {
            if (IdCrad[i].matches(regex)) {
                System.out.println(IdCrad[i]+"号码是身份证");
            } else {
                System.out.println(IdCrad[i]+"号码不是身份证");
            }
        }
    }
    /*
     *测试手机号码的正则表达式
     */
    @Test
    public void PhonenumberTest(){
        /*
            号码总共分为17、14、13、15、18开头，[0-9]匹配0-9的任意数字，[^4,\\d]匹配除了4的任意数字，
            \d表示任何数字，\d{8}表示匹配8位的任意数字，号码总共11位
        */
        String regex = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\d])|(18[0-9]))\\d{8}$";
        //测试看看15开头的第三位我输入4看看是否匹配出不是手机号码，因为15开头的第三位不能是4

        String[] phoneNumber = {"17234565110","15434565119","18234565341"};

        for (int i=0;i<phoneNumber.length;i++){
            if (phoneNumber[i].matches(regex)){
                System.out.println(phoneNumber[i]+"号码是正确手机号码格式");
            }
            else{
                System.out.println(phoneNumber[i]+"号码不是正确手机号码格式");
            }
        }
    }
    /**
     * 测试邮箱的正则表达式
     */
    @Test
    public void emailTest(){

        /**
         *  \w ：与任何单词字符匹配，包括下划线
         *  \. 将”.”标记为特殊字符，即匹配”.”号
         *   * ：匹配前一个字符零次或几次    例如这里可以匹配“.zheng”这种格式
         *   + ：匹配前一个字符一次或多次
         *   (pattern) 与模式匹配并记住匹配
         *   [a-z] ：表示某个范围内的字符，a-z中的某个单词字符
         */
        //所以格式为“任意单词字符”+“.+任意单词字符”(可有这种格式，也可无)+"@+任意字符"+".+任意字符"
        //所以可以匹配zjx@qq.com或者jiaxin.zheng@qq.com.cn   这种@前面还有.的格式
        String regex = "^([a-zA-Z])+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        //可以看出前2种格式是正确的，第三种第一个字符必须是字母，他是_，所以这种格式应该是错误的

        String[] email = {"zjx@qq.com","jiaxin.zheng@qq.com.cn","_j_x@qq.com.cn"};

        for (int i=0;i<email.length;i++){
            if (email[i].matches(regex)){
                System.out.println(email[i]+"邮箱格式是正确的");
            }else {
                System.out.println(email[i]+"邮箱格式是错误的");
            }
        }
    }

    /**
     * 测试密码强度，应该是 大小写字符+数字+密码长度8到20位
     */
    @Test
    public void passwordTest(){

        /**
         * ^[a-zA-Z0-9]{8,20}$
         * (?=.*[a-z]) 任意字符串后有一小写字母
         * (?=.*[A-Z]) 任意字符串后有一大写字母
         * (?=.*\\d) 任意字符串后有一数字
         * .{8,20} 8-20位任意字符
         */
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(.{8,20})$";

        String[] password = {"zhengjxin","zhengjiaxin111","Zjix11eujs","z8Ss22"};

        for (int i=0;i<password.length;i++){
            if (password[i].matches(regex)){
                System.out.println(password[i]+"密码强度合适");
            }else {
                System.out.println(password[i]+"密码强度不合适，密码应该由大小写字母+数字，长度8-20位");
            }
        }

    }
}
