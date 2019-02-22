package com.dylan.eureka.serverClient.project.dao;

import com.dylan.eureka.serverClient.project.model.GatewayRouteDefinition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 16:37 2019/2/19
 * @Modified By:
 */
@Mapper
public interface GatewayRouteMapper {

    //查询出所有路由信息
    List<GatewayRouteDefinition> queryList();

    //保存
    int save(GatewayRouteDefinition gatewayRouteDefinition);

    //删除
    int delete(String id);

    //编辑
    int update(GatewayRouteDefinition gatewayRouteDefinition);

}
