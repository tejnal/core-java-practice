package topics.lambda.tests;

import com.corejava.lab.corejavapractice.topics.lambds.utils.modals.Employee;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-03
 */
@Slf4j
public class FunctionalInterfaceExamples {

    @Test
    public void getEmployeeNameWithHelpOfFunctions() {

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

        //from line 42 to line 59 the code is too verbose and this we customise by creating a custom method

        Function<Employee, String> getLastName = (employee -> {

            return employee.getName().substring(employee.getName().indexOf(' ') + 1);

        });

        var lastName = getLastName.apply(employees.get(1));

        log.info("Employee last name is: " + lastName);

        Function<Employee, String> getFirstName = (employee -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));

        });

        var firstName = getFirstName.apply(employees.get(1));

        log.info("Employee first name is: " + firstName);

        //random.nextBoolean , sometimes it return true and sometimes it return false
        var random = new Random();
        for(Employee employee : employees){
            if(random.nextBoolean()){
                log.info(getAName(getFirstName, employee));
            } else {
                log.info(getAName(getLastName, employee));
            }
        }

    }

    @Test
    public void getEmployeeNameUpperCaseWithHelpOfFunctions() {

        Employee mike = new Employee(24, "Mike Williams");
        Employee peter = new Employee(32, "Peter Beck");
        Employee tait = new Employee(41, "Tait Shan");
        Employee carl = new Employee(21, "Carl Styen");
        Employee johny = new Employee(47, "Johny Walker");
        Employee Martin = new Employee(56, "Martin  Danian");


        List<Employee> employees = new ArrayList<>();
        employees.add(mike);
        employees.add(peter);
        employees.add(tait);
        employees.add(carl);
        employees.add(johny);
        employees.add(Martin);

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function  chainedFunction = upperCase.andThen(firstName);

        log.info((String) chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge  = (name, employee) -> name.concat(" " + employee.getAge());

        var upperName = upperCase.apply(employees.get(0));
        log.info(concatAge.apply(upperName, employees.get(0)));

    }

    private static String getAName(Function<Employee, String> getName, Employee employee){

    return getName.apply(employee);

    }

    @Test
    public void predicateWithLambdaExample() {

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

        printEmployeeByAge(employees, "Employee age under 30 :", employee -> employee.getAge() > 30);

        printEmployeeByAge(employees, "Employee age over 30 :", employee -> employee.getAge() <= 30);

    }


    @Test
    public void predicateWithAnonymousClass() {

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

        printEmployeeByAge(employees, "Print employee age under 25: ", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

    }

    @Test
    public void useSupplierToPrintNumber() {
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(10000);
        for(int i =0; i<10; i++ ){
            log.info(String.valueOf(randomSupplier.get()));
        }


    }


    private static void printEmployeeByAge(List<Employee> employees, String ageText,
                                           Predicate<Employee> ageCondition) {
        log.info(ageText);
        log.info("=======================");
        for(Employee employee: employees) {
            if(ageCondition.test(employee)){
                log.info(employee.getName());
            }
        }

    }

    @Test
    public void testFunctionalInterface() {
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i =0; i< s.length(); i++){
                if(i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }

            }
            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("12233455680"));
        String result = everySecondChar(lambdaFunction, "12234455590");
        System.out.println(result);
    }

    @Test
    public void testSupplierFunctionalInterface() {
        Supplier<String> functionalJava = () -> "Functional Java";
        var supplierValue = functionalJava.get();
        System.out.println(supplierValue);
    }


    public static String everySecondChar(Function<String , String> func, String source ) {
        return func.apply(source);

    }






























































}
