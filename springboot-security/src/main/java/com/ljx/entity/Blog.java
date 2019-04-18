package com.ljx.entity;

import lombok.Data;

/**
 * @author lijx
 * @date 2019-03-14 14:57
 */
@Data
public class Blog {
  private Long id;
  private String name;
  private String content;

  public Blog() {
  }

  public Blog(Long id, String name, String content) {
    this.id = id;
    this.name = name;
    this.content = content;
  }
}
