package com.ba.yzl3514.domain.pre.association;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Doctor {
    private String name;
    public Doctor(String name){
        this.name = name;
    }

    // The Doctor uses a Patient object that is passed to it.
    // There is no ownership. The Doctor does not own the Patient
    public void performCheckup(Patient patient){
        System.out.println("Dr." + name + " is checking up on patient :" + patient.getName());
    }

}
