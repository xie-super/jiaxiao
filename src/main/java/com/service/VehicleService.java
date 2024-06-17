package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.VehicleEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * Author:xie-super
 * Time:2024/5/28
 * Name:IntelliJ IDEA
 */

public interface VehicleService extends IService<VehicleEntity> {
    /**
     * @param params 查询参数
     * @return 带分页的查询出来的数据
     */
    PageUtils queryPage(Map<String, Object> params);
}
