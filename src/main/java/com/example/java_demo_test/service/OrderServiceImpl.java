package com.example.java_demo_test.service;

import com.example.java_demo_test.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public void showMenu(Menu menu) {
        System.out.println("---- MENU ----");
        for(Map.Entry<String, Integer> item: menu.getMenu().entrySet()) {
            System.out.printf("%s : %d 元\n", item.getKey(), item.getValue());
        }
        System.out.println("--------------");
    }

    @Override
    public void order(Menu menu, String order, int amount) {
        for(int i = 0 ; i < amount ; i++) {
            menu.setOrder(order);
            System.out.println("已點餐: " + order);
        }
    }

    @Override
    public void showTotalPrice(Menu menu) {
        int totalPrice = 0;

        for(String item: menu.getOrder()) {
            totalPrice += menu.getMenu().get(item);
        }

        if(totalPrice > 500) {
            System.out.println("總計: " + totalPrice + " 元");
            System.out.println("售價: " + (totalPrice *= 0.9) + " 元(9折)");
        } else {
            System.out.println("總價: " + totalPrice + " 元");
        }

    }

    @Override
    public void showOrderList(Menu menu) {

        Map<String, Integer> orderAmount = new LinkedHashMap<>();
        orderAmount.put("beef", 0);
        orderAmount.put("pork", 0);
        orderAmount.put("chicken", 0);

        System.out.println("  餐點  |  單價  |  數量  |  小計  ");
        for(String order : menu.getOrder()) {
            orderAmount.put(order, orderAmount.get(order) + 1);
        }

        for(Map.Entry<String, Integer> item : menu.getMenu().entrySet()) {
            String itemName = item.getKey();
            int price = item.getValue();
            int amount = orderAmount.get(itemName);
            int sum = price * amount;

            System.out.printf("%7s   %3d元    %2d    %4d元\n", itemName, price, amount, sum);
        }
    }
}
