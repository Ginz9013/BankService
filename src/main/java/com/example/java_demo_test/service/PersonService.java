package com.example.java_demo_test.service;

import com.example.java_demo_test.entity.People;

public interface PersonService {
    void showAllpeople(People people);
    void getPersonById(People people, String id);
    void getOlderPersonByAge(People people, int age);
}
