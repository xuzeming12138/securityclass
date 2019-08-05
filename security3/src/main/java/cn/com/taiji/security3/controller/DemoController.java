package cn.com.taiji.security3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping("/")
    @ResponseBody
    public String demo(){
        return "Hello world.This is my first secuity.";
    }

    @GetMapping("/myLogin")
    public String myLogin(){
        return "myLogin";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user";
    }

    @GetMapping("/a")
    @ResponseBody
    public String a(){
        return "a";
    }

    @GetMapping("/b")
    @ResponseBody
    public String b(){
        return "b";
    }
}
