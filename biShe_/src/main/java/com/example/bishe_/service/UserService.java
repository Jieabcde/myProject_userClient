package com.example.bishe_.service;

import com.example.bishe_.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe_.model.UserModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface UserService extends IService<User> {

    /**
     * 注册
     */
    void createUser(User user);

    /**
     * 登录
     * @param userModel
     * @return
     */
    UserModel login(UserModel userModel);

    /**
     * 用户集合，查询用户信息
     * @param uidList
     */
    List<User> getUserInfo(List<Integer> uidList);

    /**
     * 更新用户信息
     * @param userModel
     */
    void updateInfo(UserModel userModel);

    /**
     * 更新密码
     * @param userModel
     */
    void updatePwd(UserModel userModel);

    /**
     * 为用户增加积分
     * @param oprice
     * @param uid
     */
    void addPoint(BigDecimal oprice, Integer uid);
}
