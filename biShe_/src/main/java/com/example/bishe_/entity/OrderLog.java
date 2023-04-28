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
@ApiModel(value="OrderLog对象", description="")
public class OrderLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "物流编号")
    private Long logid;

    @ApiModelProperty(value = "订单编号")
    private Long oid;

    @ApiModelProperty(value = "物流分类")
    private Integer logcompanyId;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;



    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic
    private Integer isDeleted;


}
