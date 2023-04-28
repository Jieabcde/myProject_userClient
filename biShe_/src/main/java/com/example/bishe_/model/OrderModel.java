package com.example.bishe_.model;

import com.example.bishe_.entity.Orders;
import com.example.bishe_.entity.UserCart;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderModel extends Orders {

    private List<UserCart> userCartList; //所购买的商品
}
