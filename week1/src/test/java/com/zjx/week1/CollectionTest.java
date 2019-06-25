package com.zjx.week1;

import com.zjx.entity.Person;
import com.zjx.entity.Student;
import org.junit.Test;


import java.util.*;

/**
 *测试Collection接口里面一些实现类的方法及其特性
 */
public class CollectionTest {

    /**
     * 测试List接口方法，以ArrayList实现类为例,测试常见方法,如add，addAll这些等等
     */
    @Test
    public void testArrayList() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(123);
        arrayList.add("AA");
        arrayList.add(new Date());

        System.out.println(arrayList.size());

        Collection c1 = Arrays.asList(1, 2, 3);
        //addAll将形参集合包含的元素都添加到当前集合
        arrayList.addAll(c1);

        System.out.println(arrayList);
        //clear清除集合所有元素
        arrayList.clear();
        //isEmpty判断集合是否为空
        System.out.println(arrayList.isEmpty());
        //contains判断是否包含某元素
        boolean b1 =arrayList.contains(123);
        System.out.println(b1);

        arrayList.add("BB");
        arrayList.add("CC");

        Person p = new Person("张三",18);
        arrayList.add(p);
        //remove删除集合的Obj元素，若删除成功，则返回true，否则返回false
        boolean b2 = arrayList.remove("BB");
        //toArray()：将集合转化为数组，可以相互转换
        Object[] objects = arrayList.toArray();
        for (int i=0;i<objects.length;i++){
            System.out.println(objects[i]);
        }
        System.out.println("------------------------");
        //iterator():返回一个iterator接口实现类的对象，进而实现集合的遍历
        Iterator iterator = arrayList.iterator();
        //方式一遍历
        for (int i =0;i<arrayList.size();i++){
            System.out.println(iterator.next());
        }
        System.out.println("--------------------------");
        //常用方式二遍历
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //使用增强for循环遍历
        System.out.println("--------------------------");
        for (Object obj:arrayList){
            System.out.println(obj);
        }
    }

    /**
     * 测试Set接口，以实现类HashSet为例，测试常用的方法
     * 记住Set的特性：无序的，不可重复的
     * Set可以添加空元素
     * contains、remove、isEmpty、clear这些类似方法就不测试了
     */
    @Test
    public void testHashSet(){
        HashSet hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(new java.lang.String("AA"));
        hashSet.add(null);
        System.out.println(hashSet.size());
        System.out.println(hashSet);

        /*当向Set添加类时，要重写equals()和hashCode()，保证不可重复性,不然
        原有的equals判断不能两个是否相同
        */
        Person p1 = new Person("李四",18);
        Person p2 = new Person("李四",18);
        hashSet.add(p1);
        hashSet.add(p2);
        //这里没有重写，所以会把2个person元素都添加进去
        System.out.println(hashSet);
        System.out.println("-----------------------");
        //使用iterator()对元素进行遍历
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 测试TreeSet的特性及自然排序
     */
    @Test
    public void testTreeSet1(){

        TreeSet treeSet = new TreeSet();
        //treeSet.add(123);
        //当在上面添加的是int类型，下面添加是String类型，这时候会报错
        //记住：TreeSet只能保存同一种object类型
        treeSet.add("123");
        treeSet.add("123");
        treeSet.add("789");
        treeSet.add("456");
        //这里会看到只输出一个123，因为treeSet保证元素的唯一性,并且会看到顺序有排序的
        //所以可以按照添加进集合的元素的指定的顺序遍历，像String会默认按照从小到大的遍历
        for (Object str:treeSet){
            System.out.println(str);
        }
        System.out.println("----------------------");
        treeSet.clear();
        //这里注意的是：把一个对象添加到 TreeSet 时，则该对象的类必须实现 Comparable 接口，
        // 实现 Comparable 的类必须实现 compareTo(Object obj) 方法
        treeSet.add(new Person("AA",20));
        treeSet.add(new Person("BB",19));
        for (Object str:treeSet){
            System.out.println(str);
        }
    }

    /**
     * 测试treeSet的比较器排序
     * 例如这里根据Student的id来进行排序
     */
    @Test
    public void testTreeSet2(){
        Comparator comparator = new Comparator() {
            /**
             *自定义比较器
             */
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student){
                    Student s1 = (Student)o1;
                    Student s2 = (Student)o2;
                    return s1.getId().compareTo(s2.getId());
                }
                return 0;
            }
        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(new Student(1002,"AA",60));
        treeSet.add(new Student(1006,"BB",78));
        treeSet.add(new Student(1001,"CC",55));
        for (Object str:treeSet){
            System.out.println(str);
        }
    }

    /**
     * 测试HashMap的主要方法及其特性
     */
    @Test
    public void testHashMap(){
        HashMap hashMap = new HashMap();

        /**
         * 测试HashMap存放值的特性
         */
        hashMap.put(1001,"AA");
        hashMap.put(1001,"BB");
        hashMap.put(1002,"CC");
        hashMap.put(new Person("张三",18),"DD");
        hashMap.put(new Person("张三",19),"EE");
        /**
         * 这里HashMap的key是用Set来存放的，不可重复，value是用Collection来存放的，不可重复，
         * 所以这保存一个key为1001的键对，当向hashMap存放实体时，会调用key所在类的equals()方法
         * 判断key是否相同，若相同加入后加的元素
         */
        System.out.println(hashMap.size());

        Object value = hashMap.get(1001);
        //所以这里输出的是后加的"BB"
        System.out.println(value);

        //1. 遍历key集
        Set set1 = hashMap.keySet();
        for (Object object:set1){
            System.out.println(object);
            //也可以通过hashMap.get(object)获取value值

        }
        //2. 遍历values集
        Collection values = hashMap.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //3. 遍历键值对，通过entrySet
        Set set2 = hashMap.entrySet();
        for (Object object:set2){
            Map.Entry entry = (Map.Entry)object;
            System.out.println(entry.getKey()+"------"+entry.getValue());
        }
    }

    /**
     * 测试TreeMap的用法及其特性
     */
    @Test
    public void testTreeMap(){

        //测试TreeMap的自然排序
        TreeMap treeMap = new TreeMap();
        //TreeMap:按照添加进的元素的key的指定顺序排序  要求：key必须是同一个类的对象
        treeMap.put(new Person("DD",18),"zjx.com");
        treeMap.put(new Person("BB",23),"shj.com");
        treeMap.put(new Person("CC",25),"xjn.com");

        Set set1 = treeMap.keySet();
        //所以这里输出是按照添加的顺序输出的
        for (Object object:set1){
            System.out.println(object+"------"+treeMap.get(object));
        }

        /*TreeMap的比较器排序与TreeSet类似一样，先重写比较器，再把比较器作为参数
         添加进TreeMap的构造器就可以，这里不做测试了
         例如：TreeMap treeMap = new TreeMap(comparator);
         */

    }


}
