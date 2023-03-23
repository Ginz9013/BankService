package com.example.java_demo_test.service;

import com.example.java_demo_test.entity.Menu;

import java.util.Map;

public interface OrderService {
    void showMenu(Menu menu);

    void order(Menu menu, String item, int amount);

    void showTotalPrice(Menu menu);

    void showOrderList(Menu menu);
}
