package com.wzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzl.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
