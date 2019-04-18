package com.ljx.service.impl;

import com.ljx.entity.Blog;
import com.ljx.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lijx
 * @date 2019-03-1418:05
 */
@Service
public class BlogServiceImpl implements BlogService {
  List<Blog> blogList =new ArrayList<>();


  public BlogServiceImpl(){
    blogList.add(new Blog(1L, " spring in action", "good!"));
    blogList.add(new Blog(2L,"spring boot in action", "nice!"));
  }
  @Override
  public List<Blog> getBlogs() {
    return blogList;
  }

  @Override
  public void deleteBlog(long id) {
    Iterator iter = blogList.iterator();
    while(iter.hasNext()) {
      Blog blog= (Blog) iter.next();
      if (blog.getId()==id){
        iter.remove();
      }
    }
  }
}
