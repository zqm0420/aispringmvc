package com.southwind.controller;


import com.southwind.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * JSP 四大作用域对应的内置对象：pageContext、request、session、application。
 *
 * 模型数据的绑定是由 ViewResolver 来完成的，实际开发中，我们需要先添加模型数据，再交给 ViewResolver 来绑定。
 *
 * Spring MVC 提供了以下几种方式添加模型数据：
 *
 * - Map
 * - Model
 * - ModelAndView
 * - @SessionAttribute
 * - @ModelAttribute
 */

@Controller
@RequestMapping("/view")
//@SessionAttributes(value = "user") //本类下的所有方法，只要向request添加了，那么就同时向session添加了（一般不推荐）
public class ViewHandler {

    /*
    1. Map
     */
    @RequestMapping("/map")
    public String map(Map<String, User> map){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        map.put("user", user);
        return "view";
    }

    /*
    2. Model
     */
    @RequestMapping("/model")
    public String model(Model model){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        model.addAttribute(user);
        return "view";
    }

    /*
    3. ModelAndView
     */
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView("view", "user", user);
        return modelAndView;
    }

    /*
    4. HttpServletRequest
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest httpServletRequest){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        httpServletRequest.setAttribute("user", user);
        return "view";
    }

    /*
    5. @ModelAttribute
     */
    //定义一个方法，该方法专门用来返回要填充到模型数据中的对象。
    @ModelAttribute
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    //业务方法中无需再处理模型数据，只需返回视图即可。
    @RequestMapping("/modelAttribute")
    public String modelAttribute(){
        return "view";
    }

    /*
    将模型数据绑定到 session 对象
     */
    @RequestMapping("/session")
    public String session(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        User user = new User();
        user.setId(2);
        user.setName("李四");
        httpSession.setAttribute("user", user);
        return "view";
    }

    /*
    同上
     */
    @RequestMapping("/session2")
    public String session2(HttpSession httpSession){
        User user = new User();
        user.setId(2);
        user.setName("李四");
        httpSession.setAttribute("user", user);
        return "view";
    }

    /*
    将模型数据绑定到application对象
     */
    @RequestMapping("/application")
    public String application(HttpServletRequest httpServletRequest){
        ServletContext servletContext = httpServletRequest.getServletContext();
        User user = new User();
        user.setId(3);
        user.setName("王五");
        servletContext.setAttribute("user", user);
        return "view";
    }






}
