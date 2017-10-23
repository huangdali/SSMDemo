package com.hdl.action;

import com.hdl.model.User;
import com.hdl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 不添加注解的话默认是http://localhost:8080/项目名字/接口名
 * eg:http://localhost:8080/springmvc/login.action?username=admin&pwd=1323
 * <p>
 * 类中添加了mapping注解：@RequestMapping("userController")
 * http://localhost:8080/springmvc/userController/login.action?username=admin&pwd=1323
 */
@Controller
@RequestMapping("userController")
public class UserServlet {
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 测试
     *
     * @return
     * @url http://localhost:8080/springmvc/test.action
     */
    @RequestMapping("/test")
    public ModelAndView test() {
        System.out.println("调用了。。。。。。");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result", "success");
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }

    /**
     * 注册
     *
     * @param user url里面的username=hdl&pwd=132会自动封装为user对象，当然也可以使用String username,String pwd
     * @return
     * @url http://localhost:8080/springmvc/registe.action?username=hdl&pwd=132
     */
    @RequestMapping("/registe")
    public void registe(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        //拿到配置文件上下文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("请求了注册。。。。。。" + user);
        PrintWriter pw = response.getWriter();
        pw.write(userService.register(user));
        pw.close();
    }

    /**
     * 用户登录
     *
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(String username, String pwd) {
        System.out.println("请求了登录。。。。。。");
        System.out.println("username=" + username);
        System.out.println("pwd=" + pwd);
        ModelAndView modelAndView = new ModelAndView();
        if ("admin".equals(username) && "132".equals(pwd)) {
            System.out.println("---2222222---");
            modelAndView.setViewName("index.jsp");
        } else {
            System.out.println("---11111111---");
            modelAndView.setViewName("/test.jsp");
        }
        modelAndView.addObject("username", username);
        modelAndView.addObject("pwd", pwd);
        return modelAndView;
    }
}
