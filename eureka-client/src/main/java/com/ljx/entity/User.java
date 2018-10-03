package com.ljx.entity;

import lombok.Data;

/**
 * @author lijx
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/30下午9:04
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String port;
}
