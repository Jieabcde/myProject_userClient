package com.example.bishe_.service;

import com.example.bishe_.config.R;
import com.example.bishe_.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe_.model.OrderModel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 获取该用户的订单详情
     * @param uid
     * @return
     */
    List<Orders> getOrder(Integer uid);

    /**
     * 下单
     * @param orderModel
     * @return
     */
    R addOrder(OrderModel orderModel);

    /**
     * 沙箱支付， 修改订单状态
     * @param outTradeNo
     */
    void editStatus(String outTradeNo);

    Integer getOrderStatus(String oid);
}
