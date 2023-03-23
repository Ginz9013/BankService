package com.example.java_demo_test;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.service.BankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaDemoTestApplicationTests {

	@Autowired
	private BankService bankService;
	@Test
	void contextLoads() {
		bankServiceTest();
	}

	public void bankServiceTest() {
		Bank bank = new Bank("Kouhei", 5000);
		bankService.getAccount(bank);
		bankService.deposit(bank, 5000);
		bankService.withdraw(bank, 3000);
		bankService.withdraw(bank, 4000);
		bankService.withdraw(bank, 5000);
	}

}
