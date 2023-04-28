package com.example.bishe_.service.impl;

import com.example.bishe_.entity.City;
import com.example.bishe_.mapper.CityMapper;
import com.example.bishe_.service.CityService;
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
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Override
    public String getCityName(Integer cityid) {
        return lambdaQuery().eq(City::getCityid,cityid).one().getCname();
    }

    @Override
    public List<City> getCityList() {
        return lambdaQuery().list();
    }
}
