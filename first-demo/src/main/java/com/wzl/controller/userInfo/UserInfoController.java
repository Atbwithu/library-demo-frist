package com.wzl.controller.userInfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzl.entity.User;
import com.wzl.mapper.UserMapper;
import com.wzl.service.UserService;
import com.wzl.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class UserInfoController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.list();
    }
    @GetMapping("/getByName")
    public ResponseResult getByName(String name){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.like("name",name);
        List<User> list = userService.list(userQueryWrapper);
        return ResponseResult.success(200,"true",list);
    }
    @RequestMapping("/deleteById")
    @Transactional
    public ResponseResult deleteById(Integer id){
        if (userService.removeById(id)){
            return ResponseResult.success(200,"true");
        }else {
            return ResponseResult.fail(200,"false");
        }
    }
}
