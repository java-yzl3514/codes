package ba.yzl3514.exercises.solution_5;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {
    public static void main(String[] args) {


        Button button = new Button("Save");
        button.setActionListener(new ActionListener() {
            @Override
            public void onAction() {
                System.out.println(button.getTitle() + " button is clicked...");
            }
        });

        button.click();


        System.out.println("program is running...");
    }
}
