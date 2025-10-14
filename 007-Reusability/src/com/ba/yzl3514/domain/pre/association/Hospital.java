package com.ba.yzl3514.domain.pre.association;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Hospital {

    public static void main(String[] args) {

        Doctor doctorSmith = new Doctor("Smith");
        Patient patientJohn = new Patient("John Doe");

        // İlişki burada vurgulanır : Doctor Smith, hasta John'u "kullanır" (uses)
        doctorSmith.performCheckup(patientJohn);

    }
}
