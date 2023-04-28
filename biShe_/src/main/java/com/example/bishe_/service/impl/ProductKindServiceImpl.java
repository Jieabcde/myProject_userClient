package com.example.bishe_.service.impl;

import com.example.bishe_.entity.ProductKind;
import com.example.bishe_.mapper.ProductKindMapper;
import com.example.bishe_.service.ProductKindService;
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
public class ProductKindServiceImpl extends ServiceImpl<ProductKindMapper, ProductKind> implements ProductKindService {


    @Override
    public List<ProductKind> getCategory() {
        return lambdaQuery().eq(ProductKind::getStatus, 1).list();
    }

    @Override
    public String getKnameByPid(Integer kid) {
        return lambdaQuery().eq(ProductKind::getKid, kid).one().getKname();
    }
}
