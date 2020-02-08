package topics.lambda.tests;

import com.corejava.lab.corejavapractice.topics.lambds.utils.modals.Employee;
import com.corejava.lab.corejavapractice.topics.lambds.utils.modals.Execute;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-02
 */
@Slf4j
public class LambdasExamples {

    @Test
    public void singleThreadWithLambda() {

        new Thread(() -> {
            log.info("This is thread start with using lambda expression ");

        }).start();
    }


    // This test can be handle much better in java 11 by replacing Comparator comparing
    // java 11 features section, will handle those
    @Test
    public void employeeComparatorTestWithoutLambda() {

        Employee mike = new Employee(24, "Mike Williams");
        Employee peter = new Employee(32, "Peter Beck");
        Employee tait = new Employee (41, "Tait Shan");

        List<Employee> employees = new ArrayList<>();
        employees.add(mike);
        employees.add(peter);
        employees.add(tait);

        Collections.sort(employees, (employee1,  employee2) -> {
                return employee1.getName().compareTo(employee2.getName());
        });

        for(Employee employee :employees) {
            log.info("Employee name is : " + employee.getName());

        }

    }

    @Test
    public void enhancedForLoopWithEmployeeComparatorTest() {

        Employee mike = new Employee(24, "Mike Williams");
        Employee peter = new Employee(32, "Peter Beck");
        Employee tait = new Employee (41, "Tait Shan");

        List<Employee> employees = new ArrayList<>();
        employees.add(mike);
        employees.add(peter);
        employees.add(tait);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        for(Employee employee :employees) {
            log.info("Employee name is : " + employee.getName());
            new Thread(() -> log.info(String.valueOf(employee.getAge()))).start();

        }

    }

    @Test
    public void lambdaWithEmployeeForEachTest() {

        Employee mike = new Employee(24, "Mike Williams");
        Employee peter = new Employee(32, "Peter Beck");
        Employee tait = new Employee (41, "Tait Shan");
        Employee carl  = new Employee(21, "Carl Styen");
        Employee johny = new Employee(47, "Johny Walker");
        Employee Martin = new Employee (56, "Martin  Danian");


        List<Employee> employees = new ArrayList<>();
        employees.add(mike);
        employees.add(peter);
        employees.add(tait);
        employees.add(carl);
        employees.add(johny);
        employees.add(Martin);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        employees.forEach(employee -> {
            log.info("Employee name : " + employee.getName());
            log.info("Employee age : " + employee.getAge());

        });

        employees.forEach(employee -> {
            var lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
                    log.info("lastName is : " + lastName);
        });

        log.info("Print employees age over 30 :");
        log.info("=============================");
        employees.forEach(employee -> {
            if(employee.getAge() >= 30){
                log.info("Print employee name : " + employee.getName());
            }

        });
        log.info("Print employees age under 30 :");
        log.info("=============================");
        employees.forEach(employee -> {
            if(employee.getAge() <= 30){
                log.info("Print employee name : " + employee.getName());
            }

        });


    }

    @Test
    public void singleThreadWithoutLambda() {
        Execute execute = new Execute();
        execute.run();

    }

    @Test
    public void singleThreadWithAnonymousClass(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("Executing Thread with anonymous class");
            }
        });

    }

    @Test
    public void convertingAnonymousClassIntoLambda() {

        Runnable runnable = () -> {
            var  myString = "Let's split this up in to array";
            String[] parts = myString.split("");
            for(String part : parts) {
                System.out.println(part);
        }
    };
        System.out.println( runnable);

        }



}
