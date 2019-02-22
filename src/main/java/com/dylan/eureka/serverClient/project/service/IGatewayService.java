package com.dylan.eureka.serverClient.project.service;

import com.dylan.eureka.serverClient.project.model.GatewayRouteDefinition;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 10:49 2019/2/20
 * @Modified By:
 */
public interface IGatewayService {

    //查询出所有路由信息
    List<GatewayRouteDefinition> queryList();

    //保存
    String save(GatewayRouteDefinition gatewayRouteDefinition);

    //删除
    int delete(String id);

    //编辑
    int update(GatewayRouteDefinition gatewayRouteDefinition);
}
