package com.ba.yzl3514.domain.pre.aggregation;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Department {
    private String name;
    private Professor[]  professors;

    public Department(String name, Professor[] professors){
        this.name = name;
        this.professors = professors;
    }

    public void listProfessors(){
        System.out.println("Department: " + name);
        for(Professor professor : professors){
            System.out.println("- Prof. " + professor.getName());
        }
    }
}
