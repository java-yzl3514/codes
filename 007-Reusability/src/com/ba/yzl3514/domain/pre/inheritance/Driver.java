package com.ba.yzl3514.domain.pre.inheritance;

import java.time.LocalDate;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        new Employee("john", "Doe","2123123", "SSN-1123",
                LocalDate.of(1978, 2,3));

        new Employee();

    }
}
