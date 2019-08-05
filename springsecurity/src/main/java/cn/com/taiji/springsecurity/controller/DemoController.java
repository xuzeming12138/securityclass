package cn.com.taiji.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
