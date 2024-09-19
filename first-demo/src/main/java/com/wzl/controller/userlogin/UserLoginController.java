package com.wzl.controller.userlogin;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.BCrypt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzl.entity.User;
import com.wzl.mapper.UserMapper;
import com.wzl.service.UserService;
import com.wzl.utils.ResponseResult;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult register(User user) {
        String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashpw);
        if (userService.save(user)){
            return ResponseResult.success(200,"注册成功！");
        }
        return ResponseResult.fail();
    }
    /**
     * 用户忘记密码
     * 通过邮箱重置密码
     */
    @PostMapping("/recoverByPhone")
    public ResponseResult recoverByPhone(String phone) {
        return ResponseResult.success(200,"找回成功！");
    }

    @PostMapping("/login")
    public ResponseResult login(String account, String password) {
        User user = userService.getOne(new QueryWrapper<User>().eq("account", account));
        if (user == null) {
            return ResponseResult.fail(400, "用户不存在");
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            if (user.getRoleId()==1){
                return ResponseResult.success(200, "登录成功",1);
            }
            return ResponseResult.success(200, "登录成功",0);
        }
        return ResponseResult.fail(400, "密码错误");
    }
}
