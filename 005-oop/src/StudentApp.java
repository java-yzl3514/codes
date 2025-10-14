/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class StudentApp {

    public static void main(String[] args) {


        Student s = new Student();

        s.name = "John";

        s = new Student();

        s.name = "Jane";

        System.out.println(s.name);
        System.out.printf("Object Address : %s, name : %s%n", s , s.name);

        changeName(s,"Bob");

        System.out.printf("Object Address : %s, name : %s%n", s , s.name);

    }


    public static void changeName(Student s, String name){
                s.name = name;
    }



}
