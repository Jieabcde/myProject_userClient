package com.example.bishe_.service.impl;

import com.example.bishe_.entity.Area;
import com.example.bishe_.mapper.AreaMapper;
import com.example.bishe_.service.AreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Override
    public String getAreaName(Integer areaid) {
        return lambdaQuery().eq(Area::getAreaid,areaid).one().getAname();
    }

    @Override
    public List<Area> getAreaList() {
        return lambdaQuery().list();
    }
}
