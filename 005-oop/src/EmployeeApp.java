/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class EmployeeApp {
    public static void main(String[] args) {

        Employee employee = new Employee("John", "Doe","SSN-0001");

        System.out.println(employee.firstName);
        System.out.println(employee.lastName);
        System.out.println(employee.ssn);
        System.out.println(employee.birthDate);
        System.out.println(employee.employmentDate);


    }
}
