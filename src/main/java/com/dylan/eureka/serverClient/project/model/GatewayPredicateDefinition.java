package com.dylan.eureka.serverClient.project.model;


import java.util.List;

/**
 * @Author: yuandh
 * @Description: 路由断言定义模型
 * @Date: Created in 15:07 2019/2/19
 * @Modified By:
 */
public class GatewayPredicateDefinition {

    private String id;

    //断言对应的Name
    private String name;

    //断言规则
    private List<GatewayPredicateRules> rules;

    // 模型定义编号
    private String definId;


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

    public List<GatewayPredicateRules> getRules() {
        return rules;
    }

    public void setRules(List<GatewayPredicateRules> rules) {
        this.rules = rules;
    }

    public String getDefinId() {
        return definId;
    }

    public void setDefinId(String definId) {
        this.definId = definId;
    }
}
