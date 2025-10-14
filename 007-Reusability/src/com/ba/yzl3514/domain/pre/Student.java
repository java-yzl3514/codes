package com.ba.yzl3514.domain.pre;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Student {
    // Every student has-a name.
    private FullName fullName;
    private String studentNumber;
    private String citizenNumber;

    public Student(FullName fullName, String citizenNumber, String studentNumber){
        this.fullName = fullName;
        this.citizenNumber = citizenNumber;
        this.studentNumber = studentNumber;
    }


    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }
}
