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
 * 订单明细表
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrderDetail对象", description="订单明细表")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "订单id")
    private Long oid;

    @ApiModelProperty(value = "数量")
    private Integer number;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;



    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic
    private Integer isDeleted;


}
