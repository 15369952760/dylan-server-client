package com.dylan.eureka.serverClient.project.dao;

import com.dylan.eureka.serverClient.project.model.GatewayFilterRules;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 14:08 2019/2/20
 * @Modified By:
 */
@Mapper
public interface GatewayFilterRulesMapper {

    int save(GatewayFilterRules gatewayFilterRules);

    int update(GatewayFilterRules gatewayFilterRules);

    int delete(String filterId);

    List<GatewayFilterRules> queryList(String filterId);
}
