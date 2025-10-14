package com.ba.yzl3514.domain.pre;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FullName {
    private String firstName;
    private String middleName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
