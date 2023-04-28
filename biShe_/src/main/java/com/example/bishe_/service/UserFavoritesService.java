package com.example.bishe_.service;

import com.example.bishe_.entity.UserFavorites;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface UserFavoritesService extends IService<UserFavorites> {

    /**
     * 加入收藏夹
     * @param userFavorites
     */
    void joinFavorites(UserFavorites userFavorites);
}
