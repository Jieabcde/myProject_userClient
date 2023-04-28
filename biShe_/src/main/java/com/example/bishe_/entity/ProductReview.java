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
@ApiModel(value="ProductReview对象", description="")
public class ProductReview implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论编号")
      @TableId(value = "rvid", type = IdType.AUTO)
    private Integer rvid;

    @ApiModelProperty(value = "用户编号")
    private Integer uid;

    @ApiModelProperty(value = "商品编号")
    private Integer pid;

    @ApiModelProperty(value = "评论内容")
    private String rvcontent;

    @ApiModelProperty(value = "评论时间")
    private LocalDateTime rvtime;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;


}
