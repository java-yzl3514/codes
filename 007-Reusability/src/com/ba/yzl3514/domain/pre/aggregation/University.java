package com.ba.yzl3514.domain.pre.aggregation;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class University {
    public static void main(String[] args) {

        Professor professorAdams = new Professor("Adams");
        Professor professorJohn = new Professor("John");

        Professor[] professors = {professorAdams, professorJohn};

        Department computerScience = new Department("Computer Science", professors);
        computerScience.listProfessors();
    }
}
