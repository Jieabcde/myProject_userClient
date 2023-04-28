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
@ApiModel(value="ProductKind对象", description="")
public class ProductKind implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类别编号")
    @TableId(value = "kid", type = IdType.AUTO)
    private Integer kid;

    @ApiModelProperty(value = "类别名字")
    private String kname;

    @ApiModelProperty(value = "图片位置")
    private String image;



    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人 员工 管理员")
    private Long createUser;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改人 员工 管理员")
    private Long updateUser;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "状态 0:禁用，1:正常")
    private Integer status;

    @TableLogic
    private Integer isDeleted;


}
