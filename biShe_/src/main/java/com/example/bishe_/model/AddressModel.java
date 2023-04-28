package com.example.bishe_.model;

import com.example.bishe_.entity.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddressModel extends Address {

    private String pname; //省份名称

    private String cname; //市名称

    private String aname; //区名称


}
