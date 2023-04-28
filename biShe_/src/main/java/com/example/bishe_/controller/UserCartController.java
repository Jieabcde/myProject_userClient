package com.example.bishe_.controller;


import com.example.bishe_.config.R;
import com.example.bishe_.entity.UserCart;
import com.example.bishe_.model.ProductDetailModel;
import com.example.bishe_.service.UserCartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/userCart")
@CrossOrigin
public class UserCartController {

    @Autowired
    private UserCartService userCartService;

    @ApiOperation(value = "将商品加入购物车", notes = "将商品加入购物车")
    @PostMapping("/joinCart")
    public R joinCart(@RequestBody UserCart userCart) {
        userCartService.joinCart(userCart);
        return R.success("加入购物车成功");
    }

    @ApiOperation(value = "获取购物车信息", notes = "获取购物车信息")
    @PostMapping("/getUserCartInfo")
    public R getUserCartInfo(@RequestBody UserCart userCart) {
       List<UserCart> cartList =userCartService.getUserCartInfo(userCart);
        return R.success(cartList);
    }

    @ApiOperation(value = "删除购物车指定商品", notes = "删除购物车指定商品")
    @GetMapping("/deleteByPid")
    public R deleteByPid(Integer cartId) {
        userCartService.removeById(cartId);
        return R.success("删除成功");
    }

    @ApiOperation(value = "减少购物车指定商品数量", notes = "减少购物车指定商品数量")
    @GetMapping("/reduceProductCartCount")
    public R reduceProductCartCount(Integer cartId ) {
        userCartService.reduceProductCartCount(cartId);
        return R.success("减少成功");
    }

    @ApiOperation(value = "增加购物车指定商品数量", notes = "增加购物车指定商品数量")
    @GetMapping("/addProductCartCount")
    public R addProductCartCount(Integer cartId ) {
        userCartService.addProductCartCount(cartId);
        return R.success("增加成功");
    }
}

