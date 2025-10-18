package ba.yzl3514.exercises.solution_5;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Button {

    private String title;
    private ActionListener listener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setActionListener(ActionListener listener) {
        this.listener = listener;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void click() {
        if (listener != null)
            listener.onAction();
    }
}
