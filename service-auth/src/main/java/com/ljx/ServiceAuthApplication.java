package com.ljx;

import com.ljx.service.impl.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class ServiceAuthApplication {

  @Autowired
  @Qualifier("dataSource")
  private DataSource dataSource;

  public static void main(String[] args) {
    SpringApplication.run(ServiceAuthApplication.class, args);
  }

  @Configuration
  @EnableAuthorizationServer
  protected class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    //private TokenStore tokenStore = new InMemoryTokenStore();
    JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceDetail userServiceDetail;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      //将客户端的信息存储在内存中
      clients.inMemory()
              //创建了一个clientId为browser的客户端
              .withClient("browser")
              //配置了验证类型为refresh_token和password
              .authorizedGrantTypes("refresh_token", "password")
              //配置了客户端域为"ui"
              .scopes("ui")
              .and()
              //接着创建另一个client，Id为"service-hi"
              .withClient("service-hi")
              //密码为123456
              .secret("123456")
              //配置了验证类型为client_credentials和refresh_token和password
              .authorizedGrantTypes("client_credentials", "refresh_token", "password")
              //配置了客户端域为"server"
              .scopes("server");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints
              .tokenStore(tokenStore)
              .authenticationManager(authenticationManager)
              .userDetailsService(userServiceDetail);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
      oauthServer
              .tokenKeyAccess("permitAll()")
              .checkTokenAccess("isAuthenticated()");

    }

  }
}
