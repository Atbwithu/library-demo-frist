package com.wzl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页查询类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private int pageNo; //页数
    private int pageSize; // 条数
    private int totalCount; // 总数
}
