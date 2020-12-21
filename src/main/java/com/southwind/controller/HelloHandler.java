package com.southwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloHandler {

    @RequestMapping(value = "/index", method = RequestMethod.GET, params = {"name", "id"})
    public String index(@RequestParam String str, @RequestParam int age){
        System.out.println("执行了index");
        return "index";

    }
}
