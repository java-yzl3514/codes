package model;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Student {

    public String firstName;
    public String lastName;
    public String studentNumber;

    public Student(){

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void printStudentInfo(){
        System.out.printf("First Name : %s,%nLast Name : %s,%nStudent Number : %s%n", firstName, lastName, studentNumber);
    }

}
