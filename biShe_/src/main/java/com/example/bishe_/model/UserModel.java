package com.example.bishe_.model;

import com.example.bishe_.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserModel extends User {

    @ApiModelProperty(value = "JWT访问令牌")
    private String token;

    private String lastpwd; //老密码
}
