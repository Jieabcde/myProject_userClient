package com.example.bishe_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.bishe_.entity.Product;
import com.example.bishe_.entity.UserCart;
import com.example.bishe_.mapper.UserCartMapper;
import com.example.bishe_.service.ProductService;
import com.example.bishe_.service.UserCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Service
public class UserCartServiceImpl extends ServiceImpl<UserCartMapper, UserCart> implements UserCartService {
    @Autowired
    private ProductService productService;

    @Override
    public void joinCart(UserCart userCart) {
        //先判断购物车有没有此商品
        UserCart dbProduct = lambdaQuery()
                .eq(UserCart::getPid, userCart.getPid())
                .eq(UserCart::getUid, userCart.getUid()).one();

        Product product = productService.getById(userCart.getPid());

        if (dbProduct != null) {
            dbProduct.setCartcount(dbProduct.getCartcount() + 1);
            dbProduct.setCartallprice(product.getPrice().multiply(new BigDecimal(dbProduct.getCartcount())));
            this.updateById(dbProduct);
            return;
        }



        userCart.setCartcount(1);
        userCart.setCartallprice(product.getPrice());
        userCart.setPname(product.getPname());
        userCart.setCartimage(product.getImage());
        userCart.setCartoneprice(product.getPrice());
        this.save(userCart);
    }

    @Override
    public List<UserCart> getUserCartInfo(UserCart userCart) {
        return lambdaQuery().eq(UserCart::getUid, userCart.getUid()).list();
    }

    @Override
    public void deleteByPid(UserCart userCart ) {
        LambdaQueryWrapper<UserCart> userCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userCartLambdaQueryWrapper
                .eq(UserCart::getPid, userCart.getPid())
                .eq(UserCart::getUid, userCart.getUid());
        this.remove(userCartLambdaQueryWrapper);
    }

    @Override
    public void reduceProductCartCount(Integer cartId) {
        UserCart userCart = this.getById(cartId);
        userCart.setCartcount(userCart.getCartcount() - 1);
        userCart.setCartallprice(userCart.getCartoneprice().multiply(new BigDecimal(userCart.getCartcount())));
        this.updateById(userCart);
    }

    @Override
    public void addProductCartCount(Integer cartId) {
        UserCart userCart = this.getById(cartId);
        userCart.setCartcount(userCart.getCartcount() + 1);
        userCart.setCartallprice(userCart.getCartoneprice().multiply(new BigDecimal(userCart.getCartcount())));
        this.updateById(userCart);
    }

    @Override
    public void removeCartProduct(Integer uid) {
        LambdaQueryWrapper<UserCart> userCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userCartLambdaQueryWrapper.eq(UserCart::getUid, uid);
        this.remove(userCartLambdaQueryWrapper);
    }
}
