package com.example.bishe_.controller;


import com.example.bishe_.config.R;
import com.example.bishe_.entity.UserCart;
import com.example.bishe_.entity.UserFavorites;
import com.example.bishe_.service.UserFavoritesService;
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
@RequestMapping("/userFavorites")
@CrossOrigin
public class UserFavoritesController {

    @Autowired
    private UserFavoritesService userFavoritesService;

    @ApiOperation(value = "将商品加入收藏夹", notes = "将商品加入收藏夹")
    @PostMapping("/joinFavorites")
    public R joinCart(@RequestBody UserFavorites userFavorites) {
        userFavoritesService.joinFavorites(userFavorites);
        return R.success("加入收藏夹成功");
    }

}

