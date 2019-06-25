package com.zjx.test;

import com.zjx.dao.RoleDao;
import com.zjx.dao.UserDao;
import com.zjx.entity.Role;
import com.zjx.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMangtoMany {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 保存一个用户，保存一个角色
     */
    @Test
    @Transactional
    @Rollback(false)
    public void  testAdd() {
        User user = new User();
        user.setUserName("小李");

        Role role = new Role();
        role.setRoleName("java程序员");

        //配置用户到角色关系，可以对中间表中的数据进行维护
        user.getRoles().add(role);

        //配置角色到用户的关系，可以对中间表的数据进行维护
        role.getUsers().add(user);

        userDao.save(user);
        roleDao.save(role);
    }

    /**
     *测试级联添加（保存一个用户的同时保存用户的关联角色）
     */
    @Test
    @Transactional
    @Rollback(false)
    public void  testCasCadeAdd() {
        User user = new User();
        user.setUserName("小李");

        Role role = new Role();
        role.setRoleName("java程序员");

        //配置用户到角色关系，可以对中间表中的数据进行维护
        user.getRoles().add(role);

        //配置角色到用户的关系，可以对中间表的数据进行维护
        role.getUsers().add(user);

        userDao.save(user);
    }
    /**
     * 删除id为1的用户，同时删除他的关联对象
     */
    @Test
    @Transactional
    @Rollback(false)
    public void  testCasCadeRemove() {
        //查询1号用户
        User user = userDao.findOne(1l);
        //删除1号用户
        userDao.delete(user);

    }
}
