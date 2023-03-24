package com.example.java_demo_test.service;

import com.example.java_demo_test.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    private Map<String, Integer> orderList = new HashMap<>();

    @Override
    public void showMenu(Menu menu) {
        System.out.println("---- MENU ----");
        for(Map.Entry<String, Integer> item: menu.getMenuList().entrySet()) {
            System.out.printf("%s : %d 元\n", item.getKey(), item.getValue());
        }
        System.out.println("--------------");
    }

    @Override
    public void order(Menu menu, String order, int amount) {

//        確認正確餐點
        if(!menu.getMenuList().containsKey(order)) {
            System.out.println("請輸入正確品項");
            return;
        }

//        確認餐點數量
        if(amount <= 0) {
            System.out.println("請輸入正確的餐點數量");
            return;
        }

//        新增餐點
        if(!orderList.containsKey(order)) {
            orderList.put(order, amount);
        } else {
            orderList.put(order, (orderList.get(order) + amount));
        }
        System.out.printf("已點餐 %s 共 %d 份\n", order, amount);
    }

    @Override
    public void showOrderList(Menu menu) {
        int totalPrice = 0;

        System.out.println("  餐點  |  單價  |  數量  |  小計  ");
        for(Map.Entry<String, Integer> item : orderList.entrySet()) {
            String orderName = item.getKey();
            int price = menu.getMenuList().get(orderName);
            int amount = item.getValue();
            int sum = price * amount;

            totalPrice += sum;

            System.out.printf("%7s   %3d元    %2d    %4d元\n", orderName, price, amount, sum);
        }

        System.out.println("");

        if(totalPrice > 500) {
            System.out.println("總計: " + totalPrice + " 元");
            System.out.println("售價: " + (totalPrice *= 0.9) + " 元(9折)");
        } else {
            System.out.println("總價: " + totalPrice + " 元");
        }
    }
}
