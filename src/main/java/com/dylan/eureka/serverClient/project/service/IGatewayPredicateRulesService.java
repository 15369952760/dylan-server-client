package com.dylan.eureka.serverClient.project.service;

import com.dylan.eureka.serverClient.project.model.GatewayPredicateRules;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 13:58 2019/2/20
 * @Modified By:
 */
public interface IGatewayPredicateRulesService {

    List<GatewayPredicateRules> queryList(String definId);

    int save(GatewayPredicateRules gatewayPredicateRules);

    int update(GatewayPredicateRules gatewayPredicateRules);

    int delete(String predicateId);

}
