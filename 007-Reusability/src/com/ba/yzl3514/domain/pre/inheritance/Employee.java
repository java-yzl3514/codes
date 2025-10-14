package com.ba.yzl3514.domain.pre.inheritance;

import java.time.LocalDate;

/**
 *
 * @author Onder Sahin
 *
 */

// Employee is a citizen.
public class Employee extends Citizen {

    private String ssn;

    public Employee(){
        System.out.println("Employee default ctor is called");
    }

    public Employee(String firstName, String lastName, String citizenNumber, String ssn, LocalDate birthDate) {
        super(firstName, lastName, citizenNumber, birthDate);
        this.ssn = ssn;
        System.out.println("Employee ctor is called");
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }
}
