package com.ljx.service.impl;

import com.ljx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author jerry
 * @date 2019-03-24 14:06
 */
public class UserServiceDetail implements UserDetailsService {
  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userDao.findByUsername(username);
  }
}
