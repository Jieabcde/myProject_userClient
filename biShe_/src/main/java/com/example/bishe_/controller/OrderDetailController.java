package com.example.bishe_.controller;


import com.example.bishe_.config.R;
import com.example.bishe_.entity.OrderDetail;
import com.example.bishe_.entity.Orders;
import com.example.bishe_.service.OrderDetailService;
import com.example.bishe_.service.OrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单明细表 前端控制器
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/orderDetail")
@CrossOrigin
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "订单详细信息", notes = "订单详细信息")
    @GetMapping("/getOrderDetail")
    public R getOrderDetail( String oid) {
        List<OrderDetail> orderDetailList =orderDetailService.getOrderDetail(oid);
        return R.success(orderDetailList);
    }

    @ApiOperation(value = "获取订单状态", notes = "获取订单状态")
    @GetMapping("/getOrderStatus")
    public R getOrderStatus( String oid) {
        Integer status = ordersService.getOrderStatus(oid);
        return R.success(status);
    }
}

