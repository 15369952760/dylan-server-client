package com.dylan.eureka.serverClient.project.model;

/**
 * @Author: yuandh
 * @Description:
 * @Date: Created in 11:33 2019/2/20
 * @Modified By:
 */
public class GatewayFilterRules {

    private String id;
    private String name;
    private String value;
    private String filterId;

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

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }
}
