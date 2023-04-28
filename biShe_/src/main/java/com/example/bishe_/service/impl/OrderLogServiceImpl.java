package com.example.bishe_.service.impl;

import cn.hutool.core.lang.UUID;
import com.example.bishe_.entity.OrderLog;
import com.example.bishe_.mapper.OrderLogMapper;
import com.example.bishe_.service.OrderLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe_.util.SnowflakeId;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Service
public class OrderLogServiceImpl extends ServiceImpl<OrderLogMapper, OrderLog> implements OrderLogService {

    @Override
    public void addOrderLog(Long oid) {
        OrderLog orderLog = new OrderLog();
        orderLog.setOid(oid);
        orderLog.setLogcompanyId(1);
        //生成雪花id
        orderLog.setLogid(SnowflakeId.nextId());
        this.save(orderLog);
    }
}
