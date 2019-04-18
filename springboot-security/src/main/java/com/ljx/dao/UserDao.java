package com.ljx.dao;

import com.ljx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jerry
 * @date 2019-03-23 21:05
 */
public interface UserDao extends JpaRepository<User, Long> {
  User findByUsername(String username);

}
