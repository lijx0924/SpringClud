package com.ljx.service.impl;

import com.ljx.feignClient.EurekaClientFeign;
import com.ljx.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/10/2下午7:14
 */
@Service
public class HiServiceImpl implements HiService {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    EurekaClientFeign eurekaClientFeign;
    @Override
    public String sayHi(String name) {
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
