package com.ljx.service.impl;

import com.ljx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jerry
 * @date 2019-03-23 21:05
 */
@Service
public class UserServiceImpl implements UserDetailsService {

  @Autowired
  private UserDao userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username);
  }
}