package com.dylan.eureka.serverClient.project.controller;

import com.dylan.eureka.serverClient.project.config.GatewayConfig;
import com.dylan.eureka.serverClient.project.model.*;
import com.dylan.eureka.serverClient.project.service.DynamicRouteServiceImpl;
import com.dylan.eureka.serverClient.project.service.IGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 15:10 2019/2/19
 * @Modified By:
 */
@RestController
@RequestMapping("/gateWay")
public class GateWayController {

    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @Autowired
    private IGatewayService gatewayService;

    //增加路由
    @PostMapping("/add")
    public String add(@RequestBody GatewayRouteDefinition gwdefinition){
        try {
            gwdefinition.setId(gatewayService.save(gwdefinition));
            RouteDefinition definition = GatewayConfig.assembleRouteDefinition(gwdefinition);
            return this.dynamicRouteService.add(definition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "succss";
    }

    //删除路由
    @DeleteMapping("/routes/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
        int row = gatewayService.delete(id);

        return this.dynamicRouteService.delete(id);

    }
    //更新路由
    @PostMapping("/update")
    public String update(@RequestBody GatewayRouteDefinition gwdefinition){
        int row = gatewayService.update(gwdefinition);
        if(row > 0){
            RouteDefinition definition = GatewayConfig.assembleRouteDefinition(gwdefinition);
            return this.dynamicRouteService.update(definition);
        } else {
            return "faild";
        }

    }
}
