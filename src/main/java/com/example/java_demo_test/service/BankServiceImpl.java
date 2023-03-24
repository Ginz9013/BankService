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

//        確認帳號
        if(bank.getAccount() == null || bank.getAccount().equals("")) {
            System.err.println("請輸入帳號");
            return;
        }

//        確認金額
        if(depositAmount <= 0) {
            System.err.println("金額不可少於0");
            return;
        }

        System.out.println("帳號: " + bank.getAccount());
        System.out.printf("取款 %d 元\n", depositAmount);
        int amount = bank.getAmount() + depositAmount;
        bank.setAmount(amount);
        System.out.println("存款後餘額:" + amount + " 元");
        System.out.println("---------------------------");
    }

    @Override
    public void withdraw(Bank bank, int withdrawAmount) {

//        確認帳號
        if(bank.getAccount() == null || bank.getAccount().equals("")) {
            System.err.println("請輸入帳號");
            return;
        }

//        確認金額
        if(withdrawAmount <= 0) {
            System.err.println("金額不可少於0");
            return;
        }

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
