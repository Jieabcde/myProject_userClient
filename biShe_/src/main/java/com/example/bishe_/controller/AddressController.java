package com.example.bishe_.controller;


import com.example.bishe_.config.R;
import com.example.bishe_.entity.*;
import com.example.bishe_.model.AddressModel;
import com.example.bishe_.service.AddressService;
import com.example.bishe_.service.AreaService;
import com.example.bishe_.service.CityService;
import com.example.bishe_.service.ProvinceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AreaService areaService;



    @ApiOperation(value = "获取用户地址", notes = "获取用户地址")
    @PostMapping("/getUserAddress")
    public R getUserAddress(@RequestBody Address address) {
        List<AddressModel> addressList =addressService.getUserAddress(address.getUid());
        return R.success(addressList);
    }

    @ApiOperation(value = "省份信息", notes = "省份信息")
    @GetMapping("/getProvinceList")
    public R getProvinceList() {
       List<Province> provinces =provinceService.getProvinceList();
        return R.success(provinces);
    }


    @ApiOperation(value = "城市信息", notes = "城市信息")
    @GetMapping("/getCityList")
    public R getCityList() {
        List<City> cityList =cityService.getCityList();
        return R.success(cityList);
    }


    @ApiOperation(value = "区/县级信息", notes = "区/县级信息")
    @GetMapping("/getAreaList")
    public R getAreaList() {
        List<Area> areaList =areaService.getAreaList();
        return R.success(areaList);
    }

    @ApiOperation(value = "添加用户地址", notes = "添加用户地址")
    @PostMapping("/addUserAddressInfo")
    public R addUserAddressInfo(@RequestBody Address address) {
        addressService.addUserAddressInfo(address);
        return R.success("添加成功");
    }

    @ApiOperation(value = "添加用户地址", notes = "添加用户地址")
    @GetMapping("/getUserAddress")
    public R getUserAddress(String uid) {
        AddressModel address=addressService.getUserAddressDef(uid);
        return R.success(address);
    }
}

