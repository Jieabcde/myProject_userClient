package com.example.bishe_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Area对象", description="")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "areaid", type = IdType.AUTO)
    private Integer areaid;

    @ApiModelProperty(value = "区名称")
    private String aname;

    @ApiModelProperty(value = "市外键")
    private Integer cityid;


}
