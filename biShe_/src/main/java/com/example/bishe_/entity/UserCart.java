package com.example.bishe_.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="UserCart对象", description="")
public class UserCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车ID")
      @TableId(value = "cartid", type = IdType.AUTO)
    private Integer cartid;

    @ApiModelProperty(value = "用户ID")
    private Integer uid;

    @ApiModelProperty(value = "商品ID")
    private Integer pid;

    @ApiModelProperty(value = "购物车数量")
    private Integer cartcount;

    @ApiModelProperty(value = "购物车单个商品价格")
    private BigDecimal cartoneprice;

    @ApiModelProperty(value = "购物车所有商品总价")
    private BigDecimal cartallprice;

    @ApiModelProperty(value = "商品名")
    private String pname;

    @ApiModelProperty(value = "商品图片")
    private String cartimage;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;


}
