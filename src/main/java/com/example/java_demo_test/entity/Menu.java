package com.example.java_demo_test.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, Integer> menuList = new LinkedHashMap<>();

    public Menu() {
//        menuList.put("beef", 100);
//        menuList.put("pork", 90);
//        menuList.put("chicken", 80);
    }
    public void setMenuList(String item, int price) {
        menuList.put(item, price);
    }

    public Map<String, Integer> getMenuList() {
        return this.menuList;
    }
}
