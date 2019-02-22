package com.dylan.eureka.serverClient.project.model;

import java.util.List;

/**
 * @Author: yuandh
 * @Description: 过滤器定义模型
 * @Date: Created in 15:07 2019/2/19
 * @Modified By:
 */
public class GatewayFilterDefinition  {

    private String id;

    //Filter Name
    private String name;

    private List<GatewayFilterRules> rules;

    private String defineId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GatewayFilterRules> getRules() {
        return rules;
    }

    public void setRules(List<GatewayFilterRules> rules) {
        this.rules = rules;
    }

    public String getDefineId() {
        return defineId;
    }

    public void setDefineId(String defineId) {
        this.defineId = defineId;
    }
}
