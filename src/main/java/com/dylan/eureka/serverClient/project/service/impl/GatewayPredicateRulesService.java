package com.dylan.eureka.serverClient.project.service.impl;

import com.dylan.eureka.serverClient.project.dao.GatewayPredicateRulesMapper;
import com.dylan.eureka.serverClient.project.model.GatewayPredicateRules;
import com.dylan.eureka.serverClient.project.model.GatewayRouteDefinition;
import com.dylan.eureka.serverClient.project.service.IGatewayPredicateRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 13:59 2019/2/20
 * @Modified By:
 */
@Service
public class GatewayPredicateRulesService implements IGatewayPredicateRulesService {

    @Autowired
    GatewayPredicateRulesMapper gatewayPredicateRulesMapper;

    @Override
    public List<GatewayPredicateRules> queryList(String definId) {
        return gatewayPredicateRulesMapper.queryList(definId);
    }

    @Override
    public int save(GatewayPredicateRules gatewayPredicateRules) {
        return gatewayPredicateRulesMapper.save(gatewayPredicateRules);
    }

    @Override
    public int update(GatewayPredicateRules gatewayPredicateRules) {
        return gatewayPredicateRulesMapper.update(gatewayPredicateRules);
    }

    @Override
    public int delete(String predicateId) {
        return gatewayPredicateRulesMapper.delete(predicateId);
    }
}
