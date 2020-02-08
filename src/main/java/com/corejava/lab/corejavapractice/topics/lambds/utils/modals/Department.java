package com.corejava.lab.corejavapractice.topics.lambds.utils.modals;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-08
 */
@Getter
@Setter
public class Department {

    private String name;
    private List<Employee> employeeList;


    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);

    }
}
