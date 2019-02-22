package com.dylan.eureka.serverClient.project.model;

/**
 * @Author: yuandh
 * @Description: 断言规则
 * @Date: Created in 11:24 2019/2/20
 * @Modified By:
 */
public class GatewayPredicateRules {

    private String id;
    private String name;
    private String value;
    private String predicateId;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPredicateId() {
        return predicateId;
    }

    public void setPredicateId(String predicateId) {
        this.predicateId = predicateId;
    }
}
