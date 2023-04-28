package com.example.bishe_.model;

import com.example.bishe_.entity.UserCart;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCartModel extends UserCart {

    private BigDecimal total; //价格总数

}
