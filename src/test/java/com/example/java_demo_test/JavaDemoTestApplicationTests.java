package com.example.java_demo_test;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.BankService;
import com.example.java_demo_test.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class JavaDemoTestApplicationTests {

	@Autowired
	private BankService bankService;

	@Autowired
	private OrderService orderService;

	@Test
	void contextLoads() {
//		bankServiceTest();

		orderServiceTest();
	}

	public void bankServiceTest() {
		Bank bank = new Bank("Kouhei", 5000);
		bankService.getAccount(bank);
		bankService.deposit(bank, 5000);
		bankService.withdraw(bank, 3000);
		bankService.withdraw(bank, 4000);
		bankService.withdraw(bank, 5000);
	}

	public void orderServiceTest() {
		Menu menu = new Menu();
		orderService.showMenu(menu);
		orderService.order(menu, "beef", 1);
		orderService.order(menu, "pork", 2);
		orderService.order(menu, "beef", 3);
		orderService.order(menu, "beef", 1);
		orderService.order(menu, "chicken", 2);
		orderService.order(menu, "pork", 1);
		orderService.order(menu, "chicken", 3);
		orderService.order(menu, "beef", 1);
		orderService.showOrderList(menu);
		orderService.showTotalPrice(menu);
	}
}
