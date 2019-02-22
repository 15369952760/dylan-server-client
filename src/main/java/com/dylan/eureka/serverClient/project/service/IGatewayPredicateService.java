package com.dylan.eureka.serverClient.project.service;

import com.dylan.eureka.serverClient.project.model.GatewayPredicateDefinition;

import java.util.List;

/**
 * @Author: yuandh
 * @Description: 断言
 * @Date: Created in 11:49 2019/2/20
 * @Modified By:
 */
public interface IGatewayPredicateService {

    List<GatewayPredicateDefinition> queryList(String defineId);

    int save(GatewayPredicateDefinition gatewayPredicateDefinition);

    int update(GatewayPredicateDefinition gatewayPredicateDefinition);

    int delete (String defineId);

}
