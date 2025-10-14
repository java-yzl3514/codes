/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Employee {
    public String firstName;
    public String lastName;
    public String ssn;
    public java.time.LocalDate birthDate;
    public java.time.LocalDate employmentDate;

    public Employee(String firstName, String lastName, String ssn){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }
}
