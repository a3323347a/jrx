package com.tool.fastJson;

import com.alibaba.fastjson.JSONObject;
import com.entity.Course;
import com.entity.User;
import org.junit.Test;

import java.util.ArrayList;

public class FashJson {
    /**
     * 测试将object转化为Json
     */
    @Test
    public void object2Json(){
        ArrayList<Course> courses = new ArrayList<Course>();
        for (int i = 0; i <3 ; i++) {
            Course c = new Course();
            c.setMath("数学"+i);
            courses.add(c);
        }
        User user = new User("xxx", 25, new String[]{"篮球", "足球"}, courses);

        String string = JSONObject.toJSONString(user);
        System.out.println(string);
    }

    /**
     * 测试将string转化为Object
     */
    @Test
    public void string2Object(){
        String json="{\"age\":18,\"courses\":[{\"math\":\"数学0\"},{\"math\":\"数学1\"},{\"math\":\"数学2\"}],\"hobby\":[\"篮球\",\"足球\"],\"name\":\"xxx\"}";


        JSONObject jsonObject = JSONObject.parseObject(json);
        User user = JSONObject.parseObject(json, User.class);
        System.out.println(user);
        //User user = (User)jsonObject;
        //System.out.println(jsonObject.get("name"));

    }

}
