package com.zjx.week1;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * 测试日期、时间格式操作及其一些类的方法
 */

public class DateTest {

    /**
     * 测试TemporalAdjuster时间校正器的一些方法和自定义时间校正器，
     * 例如自定义显示下一个工作日的方法
     */
    @Test
    public void TemporalAdjusterTest(){
        //获取当前具体时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //将当前月份的具体日期号修改成指定的日期号，例如把这月的号数修改成10号
        LocalDateTime ldt1 = localDateTime.withDayOfMonth(10);
        System.out.println(ldt1);

        //获取下个周日的具体时间
        LocalDateTime ldt2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt2);
        System.out.println("--------------------------");
        //自定义：下个工作日，如果是星期五加3天，星期六加2天，其他时间段加1天
        LocalDateTime ldt3 = localDateTime.with((l)->{
            LocalDateTime ldt4 =(LocalDateTime)l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt3);
    }

    /**
     *测试Instant : 时间戳
     */
    @Test
    public void InstantTest(){
        Instant ins = Instant.now();  //默认使用 UTC 时区
        System.out.println(ins);
        //转化为中国时区，就是加8个小时
        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        //getNano从第二时间开始获得纳秒的数量
        System.out.println(ins.getNano());


    }
    /**
     * 测试DateTimeFormatter : 解析和格式化日期或时间
     */
    @Test
    public void DateTimeFormatterTest(){
        //根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);
        //解析完就是我们所需要的格式了
        System.out.println(strDate);

        //将字符时间yyyy年MM月dd日 HH:mm:ss E解析成2019-05-31T14:19:47这个格式

        LocalDateTime newLdt = ldt.parse(strDate, dtf);
        System.out.println(newLdt);
    }

    /**
     * ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
     */
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);

        //获取时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        //set.forEach(System.out::println);
    }

    /**
     * 学习常见的日期、时间方法
     */
    @Test
    public void test2(){
        //LocalDate.of()创建任意日期， 该方法需要传入年、月、日做参数
        LocalDate date1 = LocalDate.of(2019,5,31);
        LocalDate dateToday = LocalDate.now();
        System.out.println("自建的日期："+ date1);
        //判断两个日期是否相等，equals
        if (date1.equals(dateToday)){
            System.out.println("是相同的一天！");
        }else {
            System.out.println("不是相同的一天！");
        }

        /*  检查像生日这种周期性事件，MonthDay类，这个类组合了月份和日，
            去掉了年，这意味着可以用它判断每年都会发生事件
         */
        MonthDay birhtDay = MonthDay.of(date1.getMonth(),date1.getDayOfMonth());
        MonthDay currentDay = MonthDay.from(dateToday);
        if(currentDay.equals(birhtDay)){
            System.out.println("今天是你的生日");
        }else{
            System.out.println("今天不是你的生日");
        }

        //用预定义的格式化工具去解析或格式化日期
        String dateString = "20120204";
        LocalDate formatted = LocalDate.parse(dateString,DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dateString+"变成了格式化日期："+formatted);

        //把日期转换成字符串
        LocalDateTime arrivalDate  = LocalDateTime.now();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy MM dd  hh:mm a");
        String landing = arrivalDate.format(format);
        System.out.println("转换成字符串后的日期："+landing);

    }
}
