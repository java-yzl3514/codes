/**
 * @author Onder Sahin
 */
public class SwitchStatement {


    public static void main(String[] args) {


        String day = "MONDAY";
        switch (day){
            case "MONDAY":
                System.out.println("MONDAY");
                break;
            case "TUESDAY":
                System.out.println("TUESDAY");
                break;
            //....
        }


        int x = 2;

        switch (x){
            case 1:
                System.out.println("MONDAY");
                break;
            case 2:
                System.out.println("TUESDAY");
                break;
            case 3:
                System.out.println("WEDNESDAY");
                break;
        }
    }
}

