package com.ba.yzl3514.domain.pre;

import java.time.LocalDate;

/**
 *
 * @author Onder Sahin
 *
 */
public class Employee {

    // Every employee has-a name.
    private FullName fullName;
    private String ssn;
    private LocalDate birthDate;
    private String citizenNumber;


    public Employee(FullName fullName, String ssn, String citizenNumber) {
        this(fullName, ssn, citizenNumber, null);
    }

    public Employee(FullName fullName, String ssn, String citizenNumber, LocalDate birthDate) {
        this.fullName = fullName;
        this.ssn = ssn;
        this.birthDate = birthDate;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }
}
