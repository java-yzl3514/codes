package ba.yzl3514.main;

import ba.yzl3514.domain.Employee;

import java.util.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DriverSetEmployee {

    public static void main(String[] args) {

        Set<Employee> employees = new LinkedHashSet<>();

        employees.add(new Employee(1, "John", "Doe"));

        employees.add(new Employee(2, "Jane", "Doe"));

        employees.add(new Employee(2, "Jane", "Doe"));

        System.out.println(employees);

    }
}
