package com.example.java_demo_test.service;

import com.example.java_demo_test.entity.Bank;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService{

    @Override
    public void getAccount(Bank bank) {
        System.out.println("帳號: " + bank.getAccount());
        System.out.println("餘額: " + bank.getAmount() + " 元");
        System.out.println("---------------------------");
    }

    @Override
    public void deposit(Bank bank, int depositAmount) {
        System.out.println("帳號: " + bank.getAccount());
        System.out.printf("取款 %d 元\n", depositAmount);
        int amount = bank.getAmount() + depositAmount;
        bank.setAmount(amount);
        System.out.println("存款後餘額:" + amount + " 元");
        System.out.println("---------------------------");
    }

    @Override
    public void withdraw(Bank bank, int withdrawAmount) {
        System.out.println("帳號: " + bank.getAccount());
        System.out.printf("取款 %d 元\n", withdrawAmount);

        if(withdrawAmount > bank.getAmount()) {
            System.out.println("餘額不足!");
            System.out.println("餘額: " + bank.getAmount() + " 元");
            System.out.println("---------------------------");
            return;
        }

        int amount = bank.getAmount() - withdrawAmount;
        bank.setAmount(amount);
        System.out.println("取款後餘額:" + amount + " 元");
        System.out.println("---------------------------");
    }
}
