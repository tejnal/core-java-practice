package topics.lambda.tests;

import com.corejava.lab.corejavapractice.topics.lambds.utils.modals.Bingo;
import com.corejava.lab.corejavapractice.topics.lambds.utils.modals.Department;
import com.corejava.lab.corejavapractice.topics.lambds.utils.modals.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-06
 */
@Slf4j
public class StreamsExamples {


    public Bingo bingo = new Bingo();

    @Test
    public void searchForBingoNumbersWithoutStream() {

        //create a list for all CNumbers
        List<String> cNumbers = new ArrayList<>();

        //loop through bingo number list
        bingo.createList().forEach(number -> {

            if (number.toUpperCase().startsWith("C")) {
                cNumbers.add(number);
            }
        });

        //sorting cNumbers using
        cNumbers.sort((s1, s2) -> s1.compareTo(s2));
        cNumbers.forEach(s -> System.out.println(s));
    }

    @Test
    public void searchForBingoNumbersWithStreams() {

        bingo.createList().stream()
                //method reference
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("A"))
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void sortedBingoNumbersWithCollectors() {

        List<String> aNumbers = bingo.createList()
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());

        for (String s : aNumbers) {
            log.info(s);
        }
    }

    @Test
   public void listEmployeesUsingFlatMap() {


        Employee mike = new Employee(24, "Mike Williams");
        Employee peter = new Employee(32, "Peter Beck");
        Employee tait = new Employee(41, "Tait Shan");
        Employee carl = new Employee(21, "Carl Styen");
        Employee johny = new Employee(47, "Johny Walker");
        Employee martin = new Employee(56, "Martin  Danian");

        Department informationTech = new Department("IT");
        informationTech.addEmployee(carl);
        informationTech.addEmployee(martin);
        informationTech.addEmployee(peter);

        Department computerScience = new Department("CSE");
        computerScience.addEmployee(tait);
        computerScience.addEmployee(johny);
        computerScience.addEmployee(mike);

        List<Department> departments = getDepartments(informationTech, computerScience);

        departments.stream()
                .flatMap(department ->
                        department.getEmployeeList().stream()).forEach(System.out::println);

    }



    @Test
    public void groupByEmployeesAgeUsingFlatMap() {
        Employee mike = new Employee(24, "Mike Williams");
        Employee peter = new Employee(32, "Peter Beck");
        Employee tait = new Employee(41, "Tait Shan");
        Employee carl = new Employee(21, "Carl Styen");
        Employee johny = new Employee(47, "Johny Walker");
        Employee martin = new Employee(56, "Martin  Danian");

        Department informationTech = new Department("IT");
        informationTech.addEmployee(carl);
        informationTech.addEmployee(martin);
        informationTech.addEmployee(peter);

        Department computerScience = new Department("CSE");
        computerScience.addEmployee(tait);
        computerScience.addEmployee(johny);
        computerScience.addEmployee(mike);

      List<Department> departments =  getDepartments(informationTech,  computerScience);
      Map<Integer, List<Employee>> groupByAge = departments.stream()
              .flatMap(department -> department.getEmployeeList().stream())
              .collect(Collectors.groupingBy(employee -> employee.getAge()));
      log.info("Group By Age : " + groupByAge);
        System.out.println("Group By Age : " + groupByAge);

        //Compare ages using flat map amd reduce
        System.out.println("=========================");

        departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 :e2)
                .ifPresent(System.out::println);


    }

    private List<Department> getDepartments(Department informationTech, Department computerScience) {
        List<Department> departments = new ArrayList<>();
        departments.add(informationTech);
        departments.add(computerScience);
        return departments;
    }

}
