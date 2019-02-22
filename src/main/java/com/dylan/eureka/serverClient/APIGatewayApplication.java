package com.dylan.eureka.serverClient;

import org.springframework.boot.SpringApplication;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.PropertySource;


/**
 * @Author: yuandh
 * @Description: 网关服务启动
 * @Date: Created in 11:57 2019/2/19
 * @Modified By:
 */
//@PropertySource(value={"file:application.yaml"})
@SpringCloudApplication
public class APIGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class,args);
    }

}
