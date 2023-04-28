package com.example.bishe_.controller;


import com.example.bishe_.config.R;
import com.example.bishe_.entity.User;
import com.example.bishe_.service.UserService;
import com.example.bishe_.model.UserModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping("addUser")
    public R addUser(@RequestBody User user) {
        userService.createUser(user);
        return R.success("注册成功");
    }


    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("/loginUser")
    public R loginUser(@RequestBody UserModel userModel) {
        UserModel userModel1 = userService.login(userModel);
        return R.success(userModel1,"登录成功");
    }


    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping("/updateInfo")
    public R updateInfo(@RequestBody UserModel userModel) {
         userService.updateInfo(userModel);
        return R.success("更新成功");
    }

    @ApiOperation(value = "更新用户密码", notes = "更新用户密码")
    @PostMapping("/updatePwd")
    public R updatePwd(@RequestBody UserModel userModel) {
        userService.updatePwd(userModel);
        return R.success("更新成功");
    }
}

