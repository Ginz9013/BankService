package com.example.java_demo_test.service;

import com.example.java_demo_test.entity.Bank;
import org.springframework.stereotype.Service;

@Service
public interface BankService {

    void getAccount(Bank bank);
    void deposit(Bank bank, int depositAmount);
    void withdraw(Bank bank, int withdrawAmount);
}
