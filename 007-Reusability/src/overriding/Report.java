package overriding;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Report extends Document{

    String title = "Financial Report";

    public void printInfo(){
        System.out.println("Printing from Report class");
        System.out.println("Report Title (this.title): " +  title);
        System.out.println("Original Document Title (super.title): " + super.title);
        super.printInfo();
    }

}
