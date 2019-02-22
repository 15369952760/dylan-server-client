package com.dylan.eureka.serverClient.project.dao;

import com.dylan.eureka.serverClient.project.model.GatewayFilterDefinition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 12:11 2019/2/20
 * @Modified By:
 */
@Mapper
public interface GatewayFilterMapper {

    int save(GatewayFilterDefinition gatewayFilterDefinition);

    int update(GatewayFilterDefinition gatewayFilterDefinition);

    int delete (String defineId);

    List<GatewayFilterDefinition> queryList(String routeId);
}
