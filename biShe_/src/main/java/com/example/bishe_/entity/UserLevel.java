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
@ApiModel(value="UserLevel对象", description="")
public class UserLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "等级编号")
      @TableId(value = "lid", type = IdType.AUTO)
    private Integer lid;

    @ApiModelProperty(value = "等级名称")
    private String lname;

    @ApiModelProperty(value = "等级描述")
    private String ldes;

    @ApiModelProperty(value = "等级积分规则")
    private Integer lpointRule;



    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;




    @TableLogic
    private Integer isDeleted;


}
