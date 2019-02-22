package com.dylan.eureka.serverClient.project.service.impl;

import com.dylan.eureka.serverClient.common.StringUtil;
import com.dylan.eureka.serverClient.project.dao.*;
import com.dylan.eureka.serverClient.project.model.*;
import com.dylan.eureka.serverClient.project.service.IGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 10:50 2019/2/20
 * @Modified By:
 */
@Service
public class GatewayService implements IGatewayService {

    @Autowired
    GatewayRouteMapper mapper;

    @Autowired
    GatewayPredicateMapper gatewayPredicateMapper;

    @Autowired
    GatewayPredicateRulesMapper gatewayPredicateRulesMapper;

    @Autowired
    GatewayFilterMapper gatewayFilterMapper;

    @Autowired
    GatewayFilterRulesMapper gatewayFilterRulesMapper;

    @Override
    public List<GatewayRouteDefinition> queryList() {
        List<GatewayRouteDefinition> gatewayRoutes = mapper.queryList();
        if(gatewayRoutes!=null && gatewayRoutes.size() >0){
            for (GatewayRouteDefinition route : gatewayRoutes) {
                // 断言规则保存
                List<GatewayPredicateDefinition> gatewayPredicates = gatewayPredicateMapper.queryList(route.getId());
                if(gatewayPredicates!=null && gatewayPredicates.size()>0){
                    for (GatewayPredicateDefinition predicate: gatewayPredicates) {
                        List<GatewayPredicateRules> rules = gatewayPredicateRulesMapper.queryList(predicate.getId());
                        predicate.setRules(rules);
                    }
                }
                // 路由过滤器规则保存
                List<GatewayFilterDefinition> gatewayFilters = gatewayFilterMapper.queryList(route.getId());
                if(gatewayFilters!=null && gatewayFilters.size()>0){
                    for (GatewayFilterDefinition filter :gatewayFilters) {
                        List<GatewayFilterRules> rules = gatewayFilterRulesMapper.queryList(filter.getId());
                        filter.setRules(rules);
                    }
                }
                route.setPredicates(gatewayPredicates);
                route.setFilters(gatewayFilters);
            }

        } else {
            return null;
        }
        return gatewayRoutes;
    }

    @Override
    public String save(GatewayRouteDefinition gatewayRouteDefinition) {
        String routeId = StringUtil.UUID32();//模型id
        gatewayRouteDefinition.setId(routeId);
        //保存定义模型
        mapper.save(gatewayRouteDefinition);
        //保存断言信息
        if(gatewayRouteDefinition.getPredicates()!=null && gatewayRouteDefinition.getPredicates().size()>0){
            for (GatewayPredicateDefinition predicateDefinition: gatewayRouteDefinition.getPredicates()) {
                //定义断言
                GatewayPredicateDefinition predicate = new GatewayPredicateDefinition();
                String predicateId = StringUtil.UUID32();//断言ID
                predicate.setId(predicateId);
                predicate.setDefinId(routeId);
                predicate.setName(predicateDefinition.getName());
                gatewayPredicateMapper.save(predicate);
                //保存断言规则
                if(predicateDefinition.getRules()!=null && predicateDefinition.getRules().size()>0){
                    for (GatewayPredicateRules rule : predicateDefinition.getRules()) {
                        GatewayPredicateRules gatewayPredicateRules = new GatewayPredicateRules();
                        gatewayPredicateRules.setId(StringUtil.UUID32());//规则ID
                        gatewayPredicateRules.setPredicateId(predicateId);
                        gatewayPredicateRules.setName(rule.getName());
                        gatewayPredicateRules.setValue(rule.getValue());
                        gatewayPredicateRulesMapper.save(gatewayPredicateRules);
                    }
                }
            }
        }
        // 保存路由过滤器规则
        if(gatewayRouteDefinition.getFilters()!=null && gatewayRouteDefinition.getFilters().size()>0){
            for (GatewayFilterDefinition gatewayFilterDefinition : gatewayRouteDefinition.getFilters()) {
                //定义过滤器
                GatewayFilterDefinition filter = new GatewayFilterDefinition();
                String filterId = StringUtil.UUID32();//过滤器ID
                filter.setDefineId(filterId);
                filter.setDefineId(routeId);
                filter.setName(gatewayFilterDefinition.getName());
                gatewayFilterMapper.save(filter);
                //过滤器规则保存
                if(gatewayFilterDefinition.getRules()!=null && gatewayFilterDefinition.getRules().size()>0){
                    for (GatewayFilterRules rule : gatewayFilterDefinition.getRules()) {
                        GatewayFilterRules gatewayFilterRules = new GatewayFilterRules();
                        gatewayFilterRules.setId(StringUtil.UUID32());
                        gatewayFilterRules.setFilterId(filterId);
                        gatewayFilterRules.setName(rule.getName());
                        gatewayFilterRules.setValue(rule.getValue());
                        gatewayFilterRulesMapper.save(gatewayFilterRules);
                    }
                }
            }
        }

        return routeId;
    }

    @Override
    public int delete(String id) {
        return mapper.delete(id);
    }

    @Override
    public int update(GatewayRouteDefinition gatewayRouteDefinition) {
        return mapper.update(gatewayRouteDefinition);
    }
}
