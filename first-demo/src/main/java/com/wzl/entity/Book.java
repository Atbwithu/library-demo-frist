package com.wzl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.spring.web.json.Json;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;

    private String name;

    private String author;

    private String createTime;

    private String num;

    private String isbn;

    private Json info;
}
