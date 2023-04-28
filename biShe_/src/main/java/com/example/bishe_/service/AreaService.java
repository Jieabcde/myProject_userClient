package com.example.bishe_.service;

import com.example.bishe_.entity.Area;
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
public interface AreaService extends IService<Area> {

    /**
     * 通过区域ID获取名字
     * @param areaid
     * @return
     */
    String getAreaName(Integer areaid);

    /**
     * 获取所有区县
     * @return
     */
    List<Area> getAreaList();
}
