package com.dylan.eureka.serverClient.project.dao;

import com.dylan.eureka.serverClient.project.model.GatewayPredicateRules;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 13:59 2019/2/20
 * @Modified By:
 */
@Mapper
public interface GatewayPredicateRulesMapper {

    int save(GatewayPredicateRules gatewayPredicateRules);

    int update(GatewayPredicateRules gatewayPredicateRules);

    int delete(String predicateId);

    List<GatewayPredicateRules> queryList(String definId);
}
