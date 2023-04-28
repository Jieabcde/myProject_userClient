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
@ApiModel(value="Logcompany对象", description="")
public class Logcompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流分配ID")
      @TableId(value = "logcompany_id", type = IdType.AUTO)
    private Integer logcompanyId;

    @ApiModelProperty(value = "分类名称")
    private String logcompanyName;


}
