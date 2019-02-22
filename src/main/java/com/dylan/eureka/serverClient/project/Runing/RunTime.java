package com.dylan.eureka.serverClient.project.Runing;

import com.dylan.eureka.serverClient.project.config.GatewayConfig;
import com.dylan.eureka.serverClient.project.model.*;
import com.dylan.eureka.serverClient.project.service.DynamicRouteServiceImpl;
import com.dylan.eureka.serverClient.project.service.IGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 15:30 2019/2/20
 * @Modified By:
 */
@Component
public class RunTime implements ApplicationRunner {

    @Autowired
    IGatewayService gatewayService;

    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("重启服务后 重新注册网关服务 --- " + System.currentTimeMillis());
        List<GatewayRouteDefinition> routeList = gatewayService.queryList();
        if(routeList!=null && routeList.size() >0){
            for (GatewayRouteDefinition route :routeList) {
                dynamicRouteService.staticAdd(GatewayConfig.assembleRouteDefinition(route));
            }
        }
    }

}
