package com.example.bishe_.service.impl;

import com.example.bishe_.entity.Address;
import com.example.bishe_.entity.Area;
import com.example.bishe_.mapper.AddressMapper;
import com.example.bishe_.model.AddressModel;
import com.example.bishe_.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe_.util.TypeTransUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Autowired
    private AreaService areaService;

    @Autowired
    private CityService cityService;

    @Autowired
    private ProvinceService provinceService;

    @Override
    public List<AddressModel> getUserAddress(Integer uid) {
        List<Address> addressList = lambdaQuery().eq(Address::getUid, uid).list();
//        if (addressList.size() == 0) {
//            return new ArrayList<AddressModel>();
//        }
        List<AddressModel> addressModelList = TypeTransUtil.entityListToModelList(addressList, AddressModel.class);
        addressModelList.forEach(addressModel ->{
                    addressModel.setAname(areaService.getAreaName(addressModel.getAreaid()));
                    addressModel.setCname(cityService.getCityName(addressModel.getCityid()));
                    addressModel.setPname(provinceService.getProvinceName(addressModel.getProvid()));
                });
        return addressModelList;
    }

    @Override
    public List<Area> getAreaList() {
        return null;
    }

    @Override
    public void addUserAddressInfo(Address address) {
        //先判断有没有默认地址，如果没有，则该为默认地址。如果有，则该不为默认地址
        Integer uid = address.getUid();
        Address one = lambdaQuery().eq(Address::getUid, uid).one();
        if (one == null) {
            address.setIsdefalut(1); //设置为默认
        } else {
            address.setIsdefalut(0);
        }
        this.save(address);

    }

    @Override
    public AddressModel getUserAddressDef(String uid) {
        Address address = lambdaQuery().eq(Address::getUid, uid)
                .eq(Address::getIsdefalut, 1).one();
        AddressModel addressModel = TypeTransUtil.entityToModel(address, AddressModel.class);
        addressModel.setAname(areaService.getAreaName(addressModel.getAreaid()));
        addressModel.setCname(cityService.getCityName(addressModel.getCityid()));
        addressModel.setPname(provinceService.getProvinceName(addressModel.getProvid()));
        return addressModel;
    }
}
