package com.ba.yzl3514.domain.pre.inheritance;

import java.time.LocalDate;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Citizen {
    private String firstName;
    private String lastName;
    private String citizenNumber;
    private LocalDate birthDate;

    public Citizen(){
        System.out.println("Citizen default ctor is called");
    }

    public Citizen(String firstName, String lastName, String citizenNumber, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenNumber = citizenNumber;
        this.birthDate = birthDate;
        System.out.println("Citizen ctor is called");
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
