package com.example.java_demo_test.service;

import com.example.java_demo_test.entity.People;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public void showAllpeople(People people) {
        System.out.println("-------  People List  -------");

        for(Map<String, String> person : people.getPeopleList()) {
            for(Map.Entry info : person.entrySet()) {
                System.out.println(info.getKey() + " : " + info.getValue());
            }
            System.out.println("");
        }
        System.out.println("-----------------------------");
    }

    @Override
    public void getPersonById(People people, String id) {

        System.out.println("取得 ID 為 " + id + " 的個人資料:");
        for(Map<String, String> person : people.getPeopleList()) {
            if(person.containsValue(id)) {
                for(Map.Entry info : person.entrySet()) {
                    System.out.println(info.getKey() + " : " + info.getValue());
                }
                System.out.println("");
            }
        }
        System.out.println("-----------------------------");
    }

    @Override
    public void getOlderPersonByAge(People people, int age) {

        System.out.println("取得年紀大於 " + age + " 的個人資料:");
        for(Map<String, String> person : people.getPeopleList()) {
            if(Integer.parseInt(person.get("age")) > age) {
                for(Map.Entry info : person.entrySet()) {
                    System.out.println(info.getKey() + " : " + info.getValue());
                }
                System.out.println("");
            }
        }

        System.out.println("-----------------------------");
    }
}
