package com.example.bishe_.entity;

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
@ApiModel(value="Address对象", description="")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地址编号")
      @TableId(value = "addid", type = IdType.AUTO)
    private Integer addid;

    @ApiModelProperty(value = "用户编号")
    private Integer uid;

    @ApiModelProperty(value = "省id")
    private Integer provid;

    @ApiModelProperty(value = "市id")
    private Integer cityid;

    @ApiModelProperty(value = "区id")
    private Integer areaid;

    @ApiModelProperty(value = "详细地址")
    private String addrinfo;

    @ApiModelProperty(value = "是否默认地址")
    private Integer isdefalut;

    @ApiModelProperty(value = "收货人")
    private String getpeople;

    @ApiModelProperty(value = "收货人电话")
    private String tel;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;


}
