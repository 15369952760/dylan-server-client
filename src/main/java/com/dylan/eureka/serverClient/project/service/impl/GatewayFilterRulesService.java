package com.dylan.eureka.serverClient.project.service.impl;

import com.dylan.eureka.serverClient.project.dao.GatewayFilterRulesMapper;
import com.dylan.eureka.serverClient.project.model.GatewayFilterRules;
import com.dylan.eureka.serverClient.project.service.IGatewayFilterRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 14:07 2019/2/20
 * @Modified By:
 */
@Service
public class GatewayFilterRulesService implements IGatewayFilterRulesService {

    @Autowired
    GatewayFilterRulesMapper gatewayFilterRulesMapper;


    @Override
    public List<GatewayFilterRules> queryList(String filterId) {
        return gatewayFilterRulesMapper.queryList(filterId);
    }

    @Override
    public int save(GatewayFilterRules gatewayFilterRules) {
        return gatewayFilterRulesMapper.save(gatewayFilterRules);
    }

    @Override
    public int update(GatewayFilterRules gatewayFilterRules) {
        return gatewayFilterRulesMapper.update(gatewayFilterRules);
    }

    @Override
    public int delete(String filterId) {
        return gatewayFilterRulesMapper.delete(filterId);
    }
}
