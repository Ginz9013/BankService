package com.example.java_demo_test;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.entity.People;
import com.example.java_demo_test.service.BankService;
import com.example.java_demo_test.service.OrderService;
import com.example.java_demo_test.service.OrderServiceImpl;
import com.example.java_demo_test.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JavaDemoTestApplicationTests {

	@Autowired
	private BankService bankService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private PersonService personService;

	@Test
	void contextLoads() {
//		bankServiceTest();

//		orderServiceTest();

		personInfoTest();
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

//		Set Menu
		menu.setMenuList("beef", 100);
		menu.setMenuList("pork", 90);
		menu.setMenuList("chicken", 80);

//		Show Menu
		System.out.println("");
		orderService.showMenu(menu);
		System.out.println("");

//		Order
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("請輸入餐點");
			String order = input.next();
			if(order.equals("over")) {
				System.out.println("點餐結束");
				break;
			}
			int amount =input.nextInt();
			orderService.order(menu, order, amount);
		}
		System.out.println("");

//		Cal
		orderService.showOrderList(menu);
		System.out.println("");
	}

	public void personInfoTest() {
		System.out.println("run");
		People people = new People();
		people.setPeopleList("ginz9013", "Kouhei", 28);
		people.setPeopleList("alan829221", "alan", 29);
		people.setPeopleList("inoue8892", "Inoue", 20);
		people.setPeopleList("herato922", "Herato", 18);

//		for(Object person : people.getPeopleList()) {
//			System.out.println(person);
//		}
		personService.showAllpeople(people);
		personService.getPersonById(people, "ginz9013");
		personService.getOlderPersonByAge(people, 24);
	}
}
