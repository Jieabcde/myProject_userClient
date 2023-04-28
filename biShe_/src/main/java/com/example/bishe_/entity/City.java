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
@ApiModel(value="City对象", description="")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "cityid", type = IdType.AUTO)
    private Integer cityid;

    @ApiModelProperty(value = "市名称")
    private String cname;

    @ApiModelProperty(value = "省的外键")
    private Integer provid;


}
