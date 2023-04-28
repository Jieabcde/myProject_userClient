package com.example.bishe_.service;

import com.example.bishe_.entity.Province;
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
public interface ProvinceService extends IService<Province> {

    /**
     * 通过省id获取省名
     * @param provid
     * @return
     */
    String getProvinceName(Integer provid);

    /**
     * 获取所有省份
     * @return
     */
    List<Province> getProvinceList();
}
