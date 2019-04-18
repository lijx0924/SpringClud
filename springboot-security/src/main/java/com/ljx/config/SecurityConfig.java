package com.ljx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author jerry
 * @date 2019-03-13 17:13
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/css/**", "/index").permitAll()
            .antMatchers("/user/**").hasRole("USER")
            .antMatchers("/blogs/**").hasRole("USER")
            .and()
            .formLogin().loginPage("/login").failureUrl("/login-error")
            .and()
            .exceptionHandling().accessDeniedPage("/401");
    http.logout().logoutSuccessUrl("/");
  }

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    /*auth
			.inMemoryAuthentication()
				.withUser("forezp").password("123456").roles("USER");*/
    auth.userDetailsService(userDetailsService);
  }

  /*@Bean
  @Override
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    // 在内存中存放用户信息
    manager.createUser(User.withUsername("forezp").password("123456").roles("USER").build());
    manager.createUser(User.withUsername("admin").password("123456").roles("USER", "ADMIN").build());
    return manager;
  }*/
}
