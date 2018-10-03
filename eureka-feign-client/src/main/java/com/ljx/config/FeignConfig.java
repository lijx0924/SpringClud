package com.ljx.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/10/2上午2:08
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer FeignConfig(){
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
