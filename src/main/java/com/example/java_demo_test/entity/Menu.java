package com.example.java_demo_test.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, Integer> menuList = new LinkedHashMap<>();

    private List<String> orderList = new ArrayList<>();

    public Menu() {
        menuList.put("beef", 100);
        menuList.put("pork", 90);
        menuList.put("chicken", 80);
    }

    public Map<String, Integer> getMenu() {
        return this.menuList;
    }

    public void setOrder(String order) {
        orderList.add(order);
    }

    public List<String> getOrder(){
        return this.orderList;
    };
}
