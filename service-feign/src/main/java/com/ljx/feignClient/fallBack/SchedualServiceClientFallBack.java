package com.ljx.feignClient.fallBack;

import com.ljx.feignClient.SchedualServiceClient;
import org.springframework.stereotype.Component;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/21下午2:07
 */
@Component
public class SchedualServiceClientFallBack implements SchedualServiceClient {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry" + name;
    }
}
