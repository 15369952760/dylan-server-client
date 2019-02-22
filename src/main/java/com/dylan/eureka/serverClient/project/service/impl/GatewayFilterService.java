package com.dylan.eureka.serverClient.project.service.impl;

import com.dylan.eureka.serverClient.project.dao.GatewayFilterMapper;
import com.dylan.eureka.serverClient.project.model.GatewayFilterDefinition;
import com.dylan.eureka.serverClient.project.model.GatewayPredicateDefinition;
import com.dylan.eureka.serverClient.project.model.GatewayRouteDefinition;
import com.dylan.eureka.serverClient.project.service.IGatewayFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 12:10 2019/2/20
 * @Modified By:
 */
@Service
public class GatewayFilterService implements IGatewayFilterService {

    @Autowired
    GatewayFilterMapper gatewayFilterMapper;

    @Override
    public List<GatewayFilterDefinition> queryList(String routeId) {
        return gatewayFilterMapper.queryList(routeId);
    }

    @Override
    public int save(GatewayFilterDefinition gatewayFilterDefinition) {
        return gatewayFilterMapper.save(gatewayFilterDefinition);
    }

    @Override
    public int update(GatewayFilterDefinition gatewayFilterDefinition) {
        return gatewayFilterMapper.update(gatewayFilterDefinition);
    }

    @Override
    public int delete(String defineId) {
        return gatewayFilterMapper.delete(defineId);
    }
}
