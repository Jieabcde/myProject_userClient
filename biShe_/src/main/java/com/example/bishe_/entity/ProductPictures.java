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
@ApiModel(value="ProductPictures对象", description="")
public class ProductPictures implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片编号")
      @TableId(value = "picid", type = IdType.AUTO)
    private Integer picid;

    @ApiModelProperty(value = "商品编号")
    private Integer pid;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic
    private Integer isDeleted;


}
