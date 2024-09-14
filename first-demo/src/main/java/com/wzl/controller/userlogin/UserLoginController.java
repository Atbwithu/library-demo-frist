package com.wzl.controller.userlogin;

import com.wzl.entity.User;
import com.wzl.mapper.UserMapper;
import com.wzl.service.UserService;
import com.wzl.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult register(User user) {

        if (userService.save(user)){
            return ResponseResult.success(200,"注册成功！");
        }
        return ResponseResult.fail();
    }


}
