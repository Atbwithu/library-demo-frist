package com.wzl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String account;
    private String password;
    private Integer status;
    private Integer phone;
    private String img; //头像
    private int roleId;
    private String createTime;
}
