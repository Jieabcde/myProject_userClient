package com.example.bishe_.service.impl;

import com.example.bishe_.entity.Product;
import com.example.bishe_.entity.UserFavorites;
import com.example.bishe_.mapper.UserFavoritesMapper;
import com.example.bishe_.service.ProductService;
import com.example.bishe_.service.UserFavoritesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Service
public class UserFavoritesServiceImpl extends ServiceImpl<UserFavoritesMapper, UserFavorites> implements UserFavoritesService {

    @Autowired
    private ProductService productService;

    @Override
    public void joinFavorites(UserFavorites userFavorites) {
        Product product = productService.getById(userFavorites.getPid());

        userFavorites.setPname(product.getPname());
        userFavorites.setFimage(product.getImage());

        this.save(userFavorites);
    }
}
