package com.wzl.controller.userlogin;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.BCrypt;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzl.entity.User;
import com.wzl.mapper.UserMapper;
import com.wzl.service.UserService;
import com.wzl.utils.ResponseResult;
import com.wzl.utils.ToKenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/enter")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     *用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    @Transactional
    public ResponseResult register(@RequestBody User user) {
        String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashpw);
        if (user.getName()==null){
            String string = UUID.randomUUID().toString().substring(0,7);
            string = "用户"+ string;
            user.setName(string);
//            int i = 8;
//            System.out.println(i/0);
        }
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
    public ResponseResult recoverByPhone(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("account",user.getAccount());
        if (userService.getOne(wrapper)!=null){
            userService.updateById(user);
        }
        return ResponseResult.success(200,"重置成功！");
    }

    @PostMapping("/login")
    public ResponseResult login (@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String account = user.getAccount();
        String password = user.getPassword();
        User userLocal = userService.getOne(new QueryWrapper<User>().eq("account", account));
        if (userLocal == null) {
            return ResponseResult.fail(400, "用户不存在");
        }
        if (BCrypt.checkpw(password, userLocal.getPassword())) {
            if (user.getRoleId()==1){
                session.setAttribute("user",userLocal);
                redisTemplate.opsForValue().set("userId",userLocal.getId());
                return ResponseResult.success(200, ToKenUtil.createToken(new JSONObject(userLocal)),userLocal );
            }
            redisTemplate.opsForValue().set("userId",userLocal.getId());
            session.setAttribute("user",userLocal);
            return ResponseResult.success(200, ToKenUtil.createToken(new JSONObject(userLocal)),userLocal);
        }
        return ResponseResult.fail(400, "密码错误");
    }
}
