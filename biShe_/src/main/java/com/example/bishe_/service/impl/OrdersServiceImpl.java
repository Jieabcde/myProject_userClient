package com.example.bishe_.service.impl;

import com.example.bishe_.config.R;
import com.example.bishe_.entity.Orders;
import com.example.bishe_.mapper.OrdersMapper;
import com.example.bishe_.model.OrderModel;
import com.example.bishe_.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe_.util.TypeTransUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderLogService orderLogService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserCartService userCartService;

    @Override
    public List<Orders> getOrder(Integer uid) {
        return lambdaQuery().eq(Orders::getUid, uid).list();
    }

    @Transactional
    @Override
    public R addOrder(OrderModel orderModel) {
        Orders orders = TypeTransUtil.entityToModel(orderModel, Orders.class);
        orders.setOrderTime(LocalDateTime.now());
        orders.setOstatus(2);
        //往数据库插入 Orders表
        this.save(orders);

        //往订单明细插入
        Long oid = orders.getOid(); //订单编号主键
        orderDetailService.addOrderDetail(orderModel.getUserCartList(), oid);

        //往物流表插入
        orderLogService.addOrderLog(oid);

        //用户积分增加  更新操作
        userService.addPoint(orderModel.getOprice(), orderModel.getUid());

        //货物存储减少,销量增加  更新操作
        productService.reductStock(orderModel.getUserCartList());

        //清空该用户id的购物车
        userCartService.removeCartProduct(orderModel.getUid());

        //结束
        return R.success(oid);
    }

    @Override
    public void editStatus(String outTradeNo) {
        Orders orders = this.getById(Long.valueOf(outTradeNo));
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setOstatus(1);
        this.updateById(orders);
    }

    @Override
    public Integer getOrderStatus(String oid) {
        return this.getById(oid).getOstatus();
    }
}
