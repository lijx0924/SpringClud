package com.ljx.dao;

import com.ljx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jerry
 * @date 2019-03-24 14:08
 */
public interface UserDao extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
