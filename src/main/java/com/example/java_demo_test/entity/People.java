package com.example.java_demo_test.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class People {
    private List<Map<String, String>> peopleList = new ArrayList<>();

    public void setPeopleList(String id, String name, int age) {
        Map<String, String> newPerson = new HashMap<>();
        newPerson.put("id", id);
        newPerson.put("name", name);
        newPerson.put("age", Integer.toString(age));

        this.peopleList.add(newPerson);
    }

    public List<Map<String, String>> getPeopleList() {
        return this.peopleList;
    }
}
