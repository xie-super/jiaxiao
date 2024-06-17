package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.VehicleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Author:xie-super
 * Time:2024/5/28
 * Name:IntelliJ IDEA
 */
public interface VehicleDao extends BaseMapper<VehicleEntity> {
    List<VehicleEntity> selectListView(Pagination page, @Param("params") Map<String,Object> params);
}
