package com.example.bishe_.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户编号")
      @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    @ApiModelProperty(value = "等级编号")
    private Integer lid;

    @ApiModelProperty(value = "姓名")
    private String uname;

    @ApiModelProperty(value = "电话")
    private String utel;

    @ApiModelProperty(value = "邮箱")
    private String uemail;

    @ApiModelProperty(value = "密码")
    private String upwd;

    @ApiModelProperty(value = "当前积分")
    private BigDecimal nowpoint;

    @ApiModelProperty(value = "累计积分")
    private BigDecimal hispoint;

    @ApiModelProperty(value = "头像存储位置")
    private String image;

    @ApiModelProperty(value = "状态 1禁用 0启用")
    private Integer status;



    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;


}
