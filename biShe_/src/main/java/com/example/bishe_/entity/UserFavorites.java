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
@ApiModel(value="UserFavorites对象", description="")
public class UserFavorites implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "favoid", type = IdType.AUTO)
    private Integer favoid;

    @ApiModelProperty(value = "用户编号")
    private Integer uid;

    @ApiModelProperty(value = "商品编号")
    private Integer pid;

    @ApiModelProperty(value = "状态")
    private String pname;

    private BigDecimal price;

    private String fimage;



    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;


}
