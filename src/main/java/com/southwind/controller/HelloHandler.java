package com.southwind.controller;

import com.southwind.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
 * @Controller 在类定义处添加，将该类交给 IoC 容器来管理（结合 springmvc.xml 的自动扫描配置使用），
 * 同时使其成为一个控制器，可以接收客户端请求。该控制器的每一个业务方法的返回值都会交给视图解析器进行解析
 */
@Controller
/*
 * Spring MVC 通过 @RequestMapping 注解将 URL 请求与业务方法进行映射，
 * 在 Handler 的类定义处以及方法定义处都可以添加 @RequestMapping ，
 * 在类定义处添加，相当于客户端多了一层访问路径。
 */
@RequestMapping("/hello")//如果有多个handler有index方法，那么可以加上这个前缀，访问就需要/hello/index
public class HelloHandler {

    @RequestMapping(value = "/index", method = RequestMethod.GET, params = {"name", "id=10"})
    public String index(@RequestParam("name") String str, @RequestParam("id") int age){
        System.out.println(str);
        System.out.println(age);
        System.out.println("执行了index");
        //返回的逻辑视图，springmvc.xml中的视图解析器将其转为物理视图的路径，也就是/index.jsp返回给客户端
        return "index";

    }

    /*
     * 支持 RESTful 风格的 URL
     * 传统类型：http://localhost:8080/hello/rest?name=zhangsan&id=10
     * Rest风格：http://localhost:8080/hello/rest/zhangsan/10
     * 通过 @PathVariable 注解完成请求参数与形参的映射。
     * @param name
     * @param id
     * @return
     */
    @RequestMapping("/rest/{name}/{id}")
    public String rest(@PathVariable("name") String name, @PathVariable("id") int id){
        System.out.println(name);
        System.out.println(id);
        return "index";
    }

    /*
     * 映射Cookie
     * Spring MVC 通过映射可以直接在业务方法中获取 Cookie 的值。
     * @param sessionID
     * @return
     */
    @RequestMapping("/cookie")
    public String cookie(@CookieValue("JSESSIONID") String sessionID){
        System.out.println(sessionID);
        return "index";
    }

    /*
     * 使用 JavaBean 绑定参数
     * Spring MVC 会根据请求参数名和 JavaBean 属性名进行自动匹配，
     * 自动为对象填充属性值，同时支持及联属性。
     * @param user
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user);
        return "index";
    }

    /*
     * JSP 页面的转发：
     * Spring MVC 默认是以转发的形式响应 JSP。
     * @return
     */
    public String forward(){
        System.out.println("这是转发");
        return "forward:/index.jsp";
        //  return "index";
    }

    /*
     * JSP 页面的重定向：
     * @return
     */
    public String redirect(){
        System.out.println("这是重定向");
        return "redirect:/index.jsp";
    }

}
