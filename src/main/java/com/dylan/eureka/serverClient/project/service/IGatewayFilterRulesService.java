package com.dylan.eureka.serverClient.project.service;

import com.dylan.eureka.serverClient.project.model.GatewayFilterRules;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 14:06 2019/2/20
 * @Modified By:
 */
public interface IGatewayFilterRulesService {

    List<GatewayFilterRules> queryList(String filterId);

    int save(GatewayFilterRules gatewayFilterRules);

    int update(GatewayFilterRules gatewayFilterRules);

    int delete(String filterId);

}
