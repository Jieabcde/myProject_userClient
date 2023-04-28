package com.example.bishe_.service;

import com.example.bishe_.entity.UserCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface UserCartService extends IService<UserCart> {

    /**
     * 加入购物车
     * @param userCart
     */
    void joinCart(UserCart userCart);

    /**
     * 获取该用户的购物车
     * @param userCart
     */
    List<UserCart> getUserCartInfo(UserCart userCart);

    /**
     * 从购物车中删除
     */
    void deleteByPid(UserCart userCart );

    /**
     * 减少数量
     * @param cartId
     */
    void reduceProductCartCount(Integer cartId);

    /**
     * 增加数量
     */
    void addProductCartCount(Integer cartId);

    /**
     * 清空该用户的购物车
     * @param uid
     */
    void removeCartProduct(Integer uid);
}
