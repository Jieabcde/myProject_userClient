package com.example.bishe_.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TypeTransUtil {
    /**
     * 将entityList转换成modelList
     * @param fromList 来源list
     * @param tClass 目标类型
     * @param <F> 集合元素类型
     * @param <T> 目标元素类型
     * @return 目标集合
     */
    public static<F,T> List<T> entityListToModelList(List<F> fromList, Class<T> tClass){
        if(CollectionUtils.isEmpty(fromList)){
            return null;
        }
        List<T> tList = new ArrayList<>();
        for(F f : fromList){
            T t = entityToModel(f, tClass);
            tList.add(t);
        }
        return tList;
    }


    /**
     * 将entity转换成model
     * @param entity 代转换实体
     * @param modelClass 目标Class
     * @param <F> 代转换类型
     * @param <T> 目标类型
     * @return 目标类
     */
    public static<F,T> T entityToModel(F entity, Class<T> modelClass) {
        log.debug("entityToModel : Entity属性的值赋值到Model");
        Object model = null;
        if (entity == null || modelClass ==null) {
            return null;
        }
        try {
            model = modelClass.newInstance();
        } catch (InstantiationException e) {
            log.error("entityToModel : 实例化异常", e);
        } catch (IllegalAccessException e) {
            log.error("entityToModel : 安全权限异常", e);
        }
        BeanUtils.copyProperties(entity, model);
        return (T)model;
    }
}



