package com.dylan.eureka.serverClient.project.dao;

import com.dylan.eureka.serverClient.project.model.GatewayPredicateDefinition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yuandh
 * @Description: 断言
 * @Date: Created in 11:54 2019/2/20
 * @Modified By:
 */
@Mapper
public interface GatewayPredicateMapper {

    List<GatewayPredicateDefinition> queryList(String defineId);

    int save(GatewayPredicateDefinition gatewayPredicateDefinition);

    int update(GatewayPredicateDefinition gatewayPredicateDefinition);

    int delete (String defineId);

}
