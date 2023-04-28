package com.example.bishe_.service;

import com.example.bishe_.entity.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe_.entity.UserCart;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface OrderDetailService extends IService<OrderDetail> {

    /**
     * 查看订单详情
     * @param oid
     * @return
     */
    List<OrderDetail> getOrderDetail(String oid);

    /**
     * 插入订单明细
     * @param userCartList
     * @param oid
     */
    void addOrderDetail(List<UserCart> userCartList, Long oid);
}
