package com.example.bishe_.service;

import com.example.bishe_.entity.ProductLable;
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
public interface ProductLableService extends IService<ProductLable> {

    /**
     * 查找该商品对应的标签
     * @param pid
     * @return
     */
    ProductLable getLableByPid(Integer pid);
}
