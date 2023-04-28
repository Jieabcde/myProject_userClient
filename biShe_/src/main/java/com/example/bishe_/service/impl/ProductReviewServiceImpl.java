package com.example.bishe_.service.impl;

import com.example.bishe_.entity.ProductReview;
import com.example.bishe_.mapper.ProductReviewMapper;
import com.example.bishe_.service.ProductReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class ProductReviewServiceImpl extends ServiceImpl<ProductReviewMapper, ProductReview> implements ProductReviewService {

    @Override
    public List<ProductReview> getReviewByPid(Integer pid) {
        return lambdaQuery().eq(ProductReview::getPid, pid).list();

    }

    @Override
    public void addReview(ProductReview productReview) { //pid rvcont uid
        this.save(productReview);
    }
}
