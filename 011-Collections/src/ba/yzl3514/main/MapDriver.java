package ba.yzl3514.main;

import ba.yzl3514.domain.Employee;
import ba.yzl3514.domain.EmployeeId;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MapDriver {

    public static void main(String[] args) {

        Map<EmployeeId, Employee> employeeMap = new HashMap<>();

        Employee john = new Employee(1,"John", "Doe");
        employeeMap.put(john.getId(), john);
        Employee jane = new Employee(2,"Jane", "Doe");
        employeeMap.put(jane.getId(), jane);

        System.out.println(employeeMap);

        for (EmployeeId e: employeeMap.keySet()){
            System.out.println(e);
        }

        for(Employee e : employeeMap.values()){
            System.out.println(e);
        }

        for(Map.Entry<EmployeeId, Employee> entry : employeeMap.entrySet()){
            System.out.println(entry.getKey() + " ===> " + entry.getValue());

        }

    }
}
