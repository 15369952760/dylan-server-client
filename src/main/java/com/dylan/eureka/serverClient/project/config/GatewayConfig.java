package com.dylan.eureka.serverClient.project.config;

import com.dylan.eureka.serverClient.project.model.*;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 16:17 2019/2/20
 * @Modified By:
 */
public class GatewayConfig {

    // 路由定义模型转换 -> RouteDefinition
    public static RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gwdefinition) {
        RouteDefinition definition = new RouteDefinition();
        List<PredicateDefinition> pdList=new ArrayList<>();
        List<FilterDefinition> fdList = new ArrayList<>();
        //设置编号
        definition.setId(gwdefinition.getId());
        // 断言规则
        List<GatewayPredicateDefinition> gatewayPredicateDefinitionList=gwdefinition.getPredicates();
        if(gatewayPredicateDefinitionList!=null && gatewayPredicateDefinitionList.size() > 0){
            for (GatewayPredicateDefinition gpDefinition: gatewayPredicateDefinitionList) {
                PredicateDefinition predicate = new PredicateDefinition();
                Map<String, String> args = new LinkedHashMap<>();
                for (GatewayPredicateRules rule :gpDefinition.getRules()) {
                    args.put(rule.getName(),rule.getValue());
                }
                predicate.setArgs(args);//断言规则
                predicate.setName(gpDefinition.getName());
                pdList.add(predicate);
            }
            definition.setPredicates(pdList);
        }
        // 路由过滤规则
        List<GatewayFilterDefinition> filters = gwdefinition.getFilters();
        if(filters!=null && filters.size() > 0){
            for (GatewayFilterDefinition gatewayFilterDefinition : filters){
                FilterDefinition filterDefinition = new FilterDefinition();
                Map<String, String> args = new LinkedHashMap<>();
                for (GatewayFilterRules rule :gatewayFilterDefinition.getRules()) {
                    args.put(rule.getName(),rule.getValue());
                }
                filterDefinition.setArgs(args);
                filterDefinition.setName(gatewayFilterDefinition.getName());
                fdList.add(filterDefinition);
            }
            definition.setFilters(fdList);
        }
        // 设置URI
        URI uri = UriComponentsBuilder.fromHttpUrl(gwdefinition.getUri()).build().toUri();
        definition.setUri(uri);
        return definition;
    }

}
