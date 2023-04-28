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
@ApiModel(value="Product对象", description="")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品编号")
    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    @ApiModelProperty(value = "类别编号")
    private Integer kid;

    @ApiModelProperty(value = "商品名称")
    private String pname;

    @ApiModelProperty(value = "商品状态 1代表上线 0代表下架")
    private Integer pstatus;

    @ApiModelProperty(value = "1代表促销 0代表不促销")
    private BigDecimal psales;

    @ApiModelProperty(value = "库存")
    private Integer pstock;

    @ApiModelProperty(value = "月销量")
    private Long pmonthsale;

    @ApiModelProperty(value = "详细信息")
    private String pmoreinfo;


    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "图片路径")
    private String image;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "积分")
    private Integer integral;


}
