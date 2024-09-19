package com.wzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzl.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
