package com.example.bishe_.service;

import com.example.bishe_.entity.OrderLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface OrderLogService extends IService<OrderLog> {

    /**
     * 物流信息
     * @param oid
     */
    void addOrderLog(Long oid);
}
