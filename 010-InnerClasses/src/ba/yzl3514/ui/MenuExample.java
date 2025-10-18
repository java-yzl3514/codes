package ba.yzl3514.ui;

import javax.swing.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MenuExample {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonFrame("Button Menu Example").setVisible(true);
            }
        });

    }

}
