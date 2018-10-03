package com.ljx.feignClient.fallBack;

import com.ljx.feignClient.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/21下午2:07
 */
@Component
public class EurekaClientFeignFallBack implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi," + name + ",sorry,error";
    }
}
