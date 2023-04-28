package com.example.bishe_.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Orders对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单编号")
      @TableId(value = "oid", type = IdType.NONE)
    private Long oid;

    @ApiModelProperty(value = "用户编号")
    private Integer uid;

    @ApiModelProperty(value = "地址编号")
    private Integer addressId;

    @ApiModelProperty(value = "付款金额")
    private BigDecimal oprice;

    @ApiModelProperty(value = "下单时间")
    private LocalDateTime orderTime;

    @ApiModelProperty(value = "付款时间")
    private LocalDateTime checkoutTime;

    @ApiModelProperty(value = "订单状态 1待发货，2待付款，3已完成，4已取消")
    private Integer ostatus;

    @ApiModelProperty(value = "订单备注")
    private String description;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "详细地址")
    private String addressInfo;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "收货人")
    private String consignee;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;



    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic
    private Integer isDeleted;


}
