package com.example.bishe_.service.impl;

import com.example.bishe_.entity.Province;
import com.example.bishe_.mapper.ProvinceMapper;
import com.example.bishe_.service.ProvinceService;
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
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {

    @Override
    public String getProvinceName(Integer provid) {
        return lambdaQuery().eq(Province::getProvid,provid).one().getPname();
    }

    @Override
    public List<Province> getProvinceList() {
        return lambdaQuery().list();
    }
}
