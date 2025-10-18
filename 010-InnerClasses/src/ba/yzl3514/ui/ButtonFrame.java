package ba.yzl3514.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ButtonFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    public ButtonFrame(String title) {
        initializeUI(title);
        prepareButtonPanel();
    }


    private void initializeUI(String title) {
        setTitle(title);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void prepareButtonPanel(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel.setBackground(Color.GRAY);


        //JButton openButton = new JButton("Open");
        OpenButton openButton = new OpenButton();
        JButton saveButton = new JButton("Save");
        JButton settingsButton = new JButton("Settings");
        JButton exitButton = new JButton("Exit");

//        openButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Open button is clicked.");
//            }
//        });

//        ButtonListener buttonListener = new ButtonListener();
//        openButton.addActionListener(buttonListener);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save button is clicked.");
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Settings button is clicked.");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit button is clicked.");
                System.exit(0);
            }
        });

        jPanel.add(openButton);
        jPanel.add(saveButton);
        jPanel.add(settingsButton);
        jPanel.add(exitButton);

        add(jPanel, BorderLayout.NORTH);

    }


    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button is clicked");
        }
    }

}
