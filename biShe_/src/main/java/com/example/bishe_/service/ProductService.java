package com.example.bishe_.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bishe_.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe_.entity.UserCart;
import com.example.bishe_.model.ProductDetailModel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface ProductService extends IService<Product> {

    /**
     * 获取销量最好的9个商品
     */
    List<Product> getProductListLimitNine();


    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    Page<Product> getPageInfo(Page<Product> pageInfo, String searchName,Integer kid);

    /**
     * 获取商品详情
     * @return
     */
    ProductDetailModel getProductDetail(Integer pid);

    /**
     * 减少货物储存
     * @param userCartList
     */
    void reductStock(List<UserCart> userCartList);
}
