package com.ljx.controller;

import com.ljx.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/30下午9:07
 */
@RestController
public class MyRestController {

    public static boolean isDB = true;

    @GetMapping(value = "/setIsDB/{isDB}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void setIsDB(@PathVariable boolean isDB) {
        isDB = isDB;
    }

    @GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@PathVariable Integer id, HttpServletRequest request){
        User user = new User();
        user.setId(id);
        user.setUsername("中文");
        user.setPassword("123");
        user.setPort(request.getRequestURL().toString());
        return user;
    }

}
