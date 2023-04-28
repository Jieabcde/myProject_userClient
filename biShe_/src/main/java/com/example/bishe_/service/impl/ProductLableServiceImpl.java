package com.example.bishe_.service.impl;

import com.example.bishe_.entity.ProductLable;
import com.example.bishe_.mapper.ProductLableMapper;
import com.example.bishe_.service.ProductLableService;
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
public class ProductLableServiceImpl extends ServiceImpl<ProductLableMapper, ProductLable> implements ProductLableService {

    @Override
    public ProductLable getLableByPid(Integer pid) {
        return lambdaQuery().eq(ProductLable::getPid, pid).one();
    }
}
