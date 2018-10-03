package com.ljx.controller;

import com.ljx.feignClient.EurekaClientFeign;
import com.ljx.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/21下午2:02
 */
@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @GetMapping("hi")
    public String sayHi(@RequestParam String name){
        return hiService.sayHi(name);
    }


}
