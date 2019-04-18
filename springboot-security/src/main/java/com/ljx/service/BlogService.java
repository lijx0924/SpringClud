package com.ljx.service;

import com.ljx.entity.Blog;

import java.util.List;

/**
 * @author lijx
 * @date 2019-03-1418:03
 */
public interface BlogService {
  /**
   * 查询
   * @return
   */
  List<Blog> getBlogs();

  /**
   * 删除
   * @param id
   */
  void deleteBlog(long id);
}
