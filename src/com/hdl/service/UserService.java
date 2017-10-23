package com.hdl.service;

import com.hdl.dao.UserDao;
import com.hdl.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {
    //@Autowired 也可以用这个
    @Resource(name = "userDao")
    private UserDao userDao;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public boolean login(User user) {
        return userDao.login(user);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public String register(User user) {
        String result;
        if (userDao.register(user)) {
            result = "{\"code\"=0,\"msg\"=\"注册成功\"}";
        } else {
            result = "{\"code\"=\"10002001\",\"msg\"=\"用户名已被注册\"}";
        }
        return result;
    }
}
