package com.zjx.week1;

import com.zjx.entity.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * 测试工具类Collections的排序、查找替换操作
 * 排序：根据类的某种属性对类进行排序
 * 查找替换：简单的查找替换
 */

public class CollectionsTest {

    static List list = new ArrayList();

    @BeforeClass
    public static void init(){

        list.add(new Student(1001,"tom",58));
        list.add(new Student(1002,"jack",45));
        list.add(new Student(1003,"jerry",98));
        list.add(new Student(1004,"rose",57));


        System.out.println("排序前：----------------");
        for (Object object:list){
            System.out.println(object);
        }
    }
    /**
     * 测试Sort排序,有2种方式
     * 自然排序和Comparator比较器排序
     */
    @Test
    public void testSort(){

        /**
         * 按照name升序自然排序
         * 需要重写类的compareTo方法
         */
        Collections.sort(list);
        System.out.println("自然排序按name升序排序后:");
        for (Object object:list){
            System.out.println(object);
        }

        /**
         * 使用Comparator比较器按age升序排序
         */
        Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore()-o2.getScore();
            }
        });
        System.out.println("使用Comparator比较器按age升序排序后:");
        for (Object object:list){
            System.out.println(object);
        }
    }
    /**
     * 测试reverse、shuffle、swap方法
     */
    @Test
    public void test1(){

        System.out.println("反转后的排序：------");
        Collections.reverse(list);
        for (Object object:list){
            System.out.println(object);
        }

        System.out.println("随机后的排序：---------");
        Collections.shuffle(list);
        for (Object object:list){
            System.out.println(object);
        }

        System.out.println("交换后的排序：---------");
        Collections.swap(list,0,2);
        Collections.shuffle(list);
        for (Object object:list){
            System.out.println(object);
        }
    }

    /**
     * 测试max、min、frequecy、copy、 replaceAll
     */
    @Test
    public void test2() {
        /*
            由于我们重写了Student的compareTo方法，是按照name名称排序的，
            所以我们调用max和min是用Student重写的compareTo进行查找的
         */
        Object object1 = Collections.max(list);
        System.out.println("该list集合中最大的元素：-----");
        System.out.println(object1);
        System.out.println("该list集合中最小的元素：-----");
        Object object2 = Collections.min(list);
        System.out.println(object2);

        //frequency出现的频率，例如我们来查找单词出现的次数
        System.out.println("查询单词出现的频率-------------------");
        String text = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";
        List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(text.split(" ")));
        Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(list, word));

        }
        System.out.println("测试替换掉指定元素---------------------");
        //测试替换掉指定元素
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("asdas");
        arrayList.add("sada");
        Collections.replaceAll(arrayList,"sada","aaa");
        for (String str:arrayList){
            System.out.println(str);
        }
    }


}
