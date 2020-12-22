package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserList;
import com.southwind.entity.UserMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据绑定：在后端的业务方法中直接获取客户端 HTTP 请求中的参数，
 * 将请求参数映射到业务方法的形参中，Spring MVC 中数据绑定的工作是由 HandlerAdapter 来完成的。
 *
 */

@RestController //  表示该控制器会直接将业务方法的返回值响应给客户端，不进行视图解析。
@RequestMapping("/data")
public class DataBindHandler {
    /*
    @ResponseBody 表示 Spring MVC 会直接将业务方法的返回值响应给客户端，如果不加 @ResponseBody 注解，
    Spring MVC 会将业务方法的放回值传递给 DispatcherServlet，
    再由 DisptacherServlet 调用 ViewResolver 对返回值进行解析，映射到一个 JSP 资源。
     */
//    @ResponseBody
    @RequestMapping("/baseType")
    public String baseType(int id){
        return id+"";
    }

    /*
    包装类可以接收 null，当 HTTP 请求没有参数时，使用包装类定义形参的数据类型，程序不会抛出异常。
     */
    @RequestMapping("/packageType")
    public String packageType(Integer id){
        return id+"";
    }

    /*
    Spring MVC 不支持 List 类型的直接转换，需要对 List 集合进行包装。
     */
    @RequestMapping("/list")
    public String list(UserList userList){
        StringBuffer str = new StringBuffer();
        for (User user :
                userList.getUsers()) {
            str.append(user);
        }
        return str.toString();
    }

    // Map类型
    @RequestMapping("map")
    public String map(UserMap users){
        StringBuffer str = new StringBuffer();
        for (String key :
                users.getUsers().keySet()) {
            User user = users.getUsers().get(key);
            str.append(user);
        }
        return str.toString();
    }
}
