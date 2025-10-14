/**
 *
 * @author Onder Sahin
 */

class __{
    // OK
}

class ___{
     // OK
}

class ${
    // OK
}

class $${
    // OK
}

class CaseSensitive{

    public static void main(String[] args) {

        int number = 0;
        //int number = 0;
        int Number = 0;
        int NUMBER = 0;

        int numberOfStudents = 100;

    }

}

class MustNotKeywords {

    public static void main(String[] args) {

        // int public = 9;
        // double strictfp = 10;

        int publicDouble = 89;
    }

}



public class Identifiers {




    public static void main(String[] args) {

        System.out.println(Character.isJavaIdentifierPart('#'));
        System.out.println(Character.isJavaIdentifierPart('_'));
        System.out.println(Character.isJavaIdentifierPart('$'));
        System.out.println(Character.isJavaIdentifierPart('!'));


        System.out.println(Character.isJavaIdentifierStart('_'));
        System.out.println(Character.isJavaIdentifierStart('$'));
        System.out.println(Character.isJavaIdentifierPart('!'));



        //int 34a; // NOT OK
        int a34; // OK
        int _98; // OK
         // int _; //only underscore character identifier it is not supported since Java 9
        int $; // OK
        int _$_$; // OK



    }

}
