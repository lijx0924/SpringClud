package com.ljx.feignClient;

import com.ljx.config.FeignConfig;
import com.ljx.feignClient.fallBack.EurekaClientFeignFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/21下午1:59
 */
@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = EurekaClientFeignFallBack.class)
public interface EurekaClientFeign {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
