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

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/info")
public class UserInfoController {
    @Autowired
    private UserService userService;

    /**
     * 查询所以用户
     * @return
     */
    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.list();
    }

    /**
     * 根据用户姓名查询
     * @param name
     * @return
     */
    @GetMapping("/getByName")
    public ResponseResult getByName(String name){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.like("name",name);
        List<User> list = userService.list(userQueryWrapper);
        return ResponseResult.success(200,"true",list);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @Transactional
    public ResponseResult deleteById(Integer id){
        if (userService.removeById(id)){
            return ResponseResult.success(200,"true");
        }else {
            return ResponseResult.fail(200,"false");
        }
    }
    /**
     * 批量删除用户
     */
    @RequestMapping("/deleteByIds")
    @Transactional
    public ResponseResult  deleteByIds(Integer[] ids){
        List<Integer> list = Arrays.asList(ids);
        boolean b = userService.removeBatchByIds(list);
        if (b){
            return ResponseResult.success(200,"true");
        }else {
            return ResponseResult.fail(200,"false");
        }
    }


}
