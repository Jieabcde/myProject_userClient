package com.example.bishe_.service;

import com.example.bishe_.entity.City;
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
public interface CityService extends IService<City> {

    /**
     * 通过Id获取城市名
     * @param cityid
     * @return
     */
    String getCityName(Integer cityid);

    /**
     * 获取所有城市
     * @return
     */
    List<City> getCityList();
}
