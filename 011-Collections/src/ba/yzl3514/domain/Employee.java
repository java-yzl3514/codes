package ba.yzl3514.domain;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Employee implements Comparable<Employee>{

    private EmployeeId id;
    private String firstName;
    private String lastName;



    public Employee(int id, String firstName, String lastName){
        this.id = new EmployeeId(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EmployeeId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        System.out.println("Employee Hash : " + Objects.hash(id, firstName, lastName));
        return Objects.hash(id.getId(), firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Employee equals");
        if(obj == null) return false;
        if(this == obj) return true;
        if(!(obj instanceof Employee)) return false;
        return id.getId() == ((Employee) obj).id.getId();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if(id.getId() < o.id.getId()) return -1;
        if(id.getId() > o.id.getId()) return 1;
        return 0;
        // Integer.compare(id, o.id);
    }

    public static final Comparator<Employee> FIRST_NAME_COMPARATOR = new EmployeeFirstNameComparator();

    private static class EmployeeFirstNameComparator implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {
            // TODO  : do this algorithm based on ASCII table
            return o1.firstName.compareTo(o2.firstName);
        }
    }
}
