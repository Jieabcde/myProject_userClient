package com.example.bishe_.controller;


import com.example.bishe_.config.R;
import com.example.bishe_.entity.Orders;
import com.example.bishe_.model.OrderModel;
import com.example.bishe_.model.ProductDetailModel;
import com.example.bishe_.service.OrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "获取订单", notes = "获取订单")
    @PostMapping("/getOrder")
    public R getProductDetail(@RequestBody Orders orders) {
       List<Orders> ordersList =ordersService.getOrder(orders.getUid());
        return R.success(ordersList);
    }

    @ApiOperation(value = "增加订单", notes = "增加订单")
    @PostMapping("/addOrder")
    public R addOrder(@RequestBody OrderModel orderModel) {
        return ordersService.addOrder(orderModel);
    }

}

