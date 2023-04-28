package com.example.bishe_.service;

import com.example.bishe_.entity.ProductReview;
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
public interface ProductReviewService extends IService<ProductReview> {

    /**
     * 查找该商品对应的评论
     * @param pid
     * @return
     */
    List<ProductReview> getReviewByPid(Integer pid);

    /**
     * 新增评论
     * @param productReview
     */
    void addReview(ProductReview productReview);
}
