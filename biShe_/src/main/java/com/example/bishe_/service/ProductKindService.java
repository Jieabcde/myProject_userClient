package com.example.bishe_.service;

import com.example.bishe_.entity.ProductKind;
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
public interface ProductKindService extends IService<ProductKind> {

    /**
     * 获取分类列表
     * @return
     */
    List<ProductKind> getCategory();

    /**
     * 通过商品ID获取分类名
     */
    String getKnameByPid(Integer kid);
}
