package ba.yzl3514.ui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class OpenButton extends JButton implements ActionListener {


    public OpenButton(){
        super("Open");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Open button is clicked.");
    }
}
