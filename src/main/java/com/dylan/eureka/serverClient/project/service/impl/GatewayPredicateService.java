package com.dylan.eureka.serverClient.project.service.impl;

import com.dylan.eureka.serverClient.common.StringUtil;
import com.dylan.eureka.serverClient.project.dao.GatewayPredicateMapper;
import com.dylan.eureka.serverClient.project.model.GatewayPredicateDefinition;
import com.dylan.eureka.serverClient.project.service.IGatewayPredicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 11:53 2019/2/20
 * @Modified By:
 */
@Service
public class GatewayPredicateService implements IGatewayPredicateService {

    @Autowired
    GatewayPredicateMapper mapper;

    @Override
    public List<GatewayPredicateDefinition> queryList(String defineId) {
        return mapper.queryList(defineId);
    }

    @Override
    public int save(GatewayPredicateDefinition gatewayPredicateDefinition) {
        return mapper.save(gatewayPredicateDefinition);
    }

    @Override
    public int update(GatewayPredicateDefinition gatewayPredicateDefinition) {
        return mapper.update(gatewayPredicateDefinition);
    }

    @Override
    public int delete(String defineId) {
        return mapper.delete(defineId);
    }
}
