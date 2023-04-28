package com.example.bishe_.service;

import com.example.bishe_.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bishe_.entity.Area;
import com.example.bishe_.model.AddressModel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
public interface AddressService extends IService<Address> {

    /**
     * 获取用户地址
     * @param uid
     * @return
     */
    List<AddressModel> getUserAddress(Integer uid);

    /**
     * 获取所有区县
     * @return
     */
    List<Area> getAreaList();

    /**
     * 添加地址
     * @param address
     */
    void addUserAddressInfo(Address address);

    /**
     * 获取用户默认地址
     * @param uid
     * @return
     */
    AddressModel getUserAddressDef(String uid);
}
