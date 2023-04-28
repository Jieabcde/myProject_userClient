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
@ApiModel(value="ProductLable对象", description="")
public class ProductLable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签编号")
      @TableId(value = "laid", type = IdType.AUTO)
    private Integer laid;

    @ApiModelProperty(value = "标签名")
    private String laname;

    @ApiModelProperty(value = "标签数据")
    private String value;

    @ApiModelProperty(value = "商品标签")
    private Integer pid;



    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;




    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer isDeleted;


}
