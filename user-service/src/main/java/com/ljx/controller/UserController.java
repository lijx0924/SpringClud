package com.ljx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/10/4下午4:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hi")
    public String hi(){
        return "I'm jerry";
    }
}
