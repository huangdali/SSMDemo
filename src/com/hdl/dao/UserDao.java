package com.hdl.dao;

import com.hdl.model.User;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDao {
    /**
     * 用户注册
     *
     * @param user
     * @return 是否注册成功
     */
    public boolean register(User user) {
        //实际开发中，是调用mybatis进行数据库的操作
        //模拟添加到数据库的操作
        System.out.println("插入数据库ing：" + user);
        return true;
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public boolean login(User user) {
        System.out.println("查找数据库中是否存在这样的用户ing ：" + user);
        if (user.getUsername().contains("admin") && user.getPwd().contains("132")) {
            return true;
        }
        return false;
    }
}
