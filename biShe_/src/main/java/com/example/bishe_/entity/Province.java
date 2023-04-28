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
@ApiModel(value="Province对象", description="")
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "provid", type = IdType.AUTO)
    private Integer provid;

    @ApiModelProperty(value = "省名称")
    private String pname;


}
