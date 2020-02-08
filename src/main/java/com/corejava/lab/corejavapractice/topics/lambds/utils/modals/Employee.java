package com.corejava.lab.corejavapractice.topics.lambds.utils.modals;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-02
 */
@Slf4j
@Setter
@Getter

public class Employee {

    private int age;
    private String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
