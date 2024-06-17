package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.entity.VehicleEntity;
import com.entity.view.GonggaoView;
import com.service.DictionaryService;
import com.service.VehicleService;
import com.utils.CommonUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Author:xie-super
 * Time:2024/5/29
 * Name:IntelliJ IDEA
 */
@Controller
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private static final Logger logger = LoggerFactory.getLogger(GonggaoController.class);
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    DictionaryService dictionaryService;
    @IgnoreAuth
    @RequestMapping("/page")
    public R getPage(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(), JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教练".equals(role))
            params.put("jiaolianId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = vehicleService.queryPage(params);

        //字典表数据转换
        List<VehicleEntity> list =(List<VehicleEntity>)page.getList();
        for(int i = 0; i<list.size(); i++){
            VehicleEntity c = list.get(i);
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }
}
