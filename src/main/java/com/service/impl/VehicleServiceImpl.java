package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.VehicleDao;
import com.entity.VehicleEntity;
import com.service.VehicleService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author:xie-super
 * Time:2024/5/28
 * Name:IntelliJ IDEA
 */
@Service
public class VehicleServiceImpl extends ServiceImpl<VehicleDao, VehicleEntity> implements VehicleService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page page = new Query<VehicleEntity>(params).getPage();
        List<VehicleEntity> list = baseMapper.selectListView(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
