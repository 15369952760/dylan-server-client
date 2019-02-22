package com.dylan.eureka.serverClient.project.service;

import com.dylan.eureka.serverClient.project.model.GatewayFilterDefinition;

import java.util.List;

/**
 * @Author: yuandh
 * @Description: 路由
 * @Date: Created in 12:09 2019/2/20
 * @Modified By:
 */
public interface IGatewayFilterService {

    List<GatewayFilterDefinition> queryList(String routeId);

    int save(GatewayFilterDefinition gatewayFilterDefinition);

    int update(GatewayFilterDefinition gatewayFilterDefinition);

    int delete (String defineId);

}
