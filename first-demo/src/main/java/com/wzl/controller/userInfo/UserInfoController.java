package com.wzl.controller.userInfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzl.entity.PageInfo;
import com.wzl.entity.User;
import com.wzl.service.UserService;
import com.wzl.service.impl.UserServiceImpl;
import com.wzl.utils.ResponseResult;
import com.wzl.utils.SavePictureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.Cacheable;

import java.io.File;
import java.util.Arrays;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/info")
public class UserInfoController {
    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 查询所以用户
     * @return
     */
    @GetMapping("/getAll")
    @Cacheable("allUser")
    public List<User> getAll(){
        return userService.list();
    }
    /**
     * 分页查询所有
     */
    @GetMapping("getAllByPage")
    public ResponseResult getAllByPage(@RequestBody PageInfo pageInfo){
        IPage<User> page = userService.page(new Page<>(pageInfo.getPageNo(), pageInfo.getPageSize()));
        return ResponseResult.success(200,"ok",page.getRecords());
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
    /**
     * 根据id查询用户
     */
    @GetMapping("getUserById")
    public ResponseResult getUserById(Integer id){
        User user = userService.getById(id);
        return ResponseResult.success(200,"true",user);
    }@GetMapping("getUserInfo")
    public ResponseResult getUserInfo(){

        User user = userService.getById((Integer)redisTemplate.opsForValue().get("userId"));
        return ResponseResult.success(200,"true",user);
    }
    /**
     * 更新用户信息
     */
    @PostMapping("updateUser")
    @Transactional
    public ResponseResult updateUser(@RequestBody User user){
        if (userService.updateById(user)){
            return ResponseResult.success(200,"修改成功");
        }
        return ResponseResult.success(200,"修改失败");
    }
    /**
     * 新增用户
     */
    @PostMapping("addUser")
    @Transactional
    public ResponseResult addUser(@RequestBody User user){
        if (userService.save(user)){
            return ResponseResult.success(200,"新增成功");
        }
        return ResponseResult.fail(400,"新增失败，请稍后重试！");
    }
    //上传用户头像
    @PostMapping("uploadPicture")
    @ResponseBody
    @Transactional
    public ResponseResult add(@RequestParam("file") MultipartFile file){
        if (file!=null){
            User user = userService.getOne(new QueryWrapper<User>()
                    .eq("id",(Integer) redisTemplate.opsForValue().get("userId")));
            String string = new SavePictureUtil().savePicture(file);
            user.setImg(string);
            if (userService.updateById(user)){
                return ResponseResult.success(200,"true");
            }
            return ResponseResult.fail(400,"上传失败");
        }
        return null;
    }

}
