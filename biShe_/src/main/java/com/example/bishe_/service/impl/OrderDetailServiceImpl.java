package com.example.bishe_.service.impl;

import com.example.bishe_.entity.OrderDetail;
import com.example.bishe_.entity.UserCart;
import com.example.bishe_.mapper.OrderDetailMapper;
import com.example.bishe_.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    @Override
    public List<OrderDetail> getOrderDetail(String oid) {
        return lambdaQuery().eq(OrderDetail::getOid, oid).list();
    }

    @Override
    public void addOrderDetail(List<UserCart> userCartList, Long oid) {
        List<OrderDetail> orderDetailList = userCartList.stream()
                .map(userCart -> {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setName(userCart.getPname());
                    orderDetail.setImage(userCart.getCartimage());
                    orderDetail.setOid(oid);
                    orderDetail.setNumber(userCart.getCartcount());
                    orderDetail.setAmount(userCart.getCartallprice());
                    return orderDetail;
                }).collect(Collectors.toList());
        this.saveBatch(orderDetailList);
    }
}
















