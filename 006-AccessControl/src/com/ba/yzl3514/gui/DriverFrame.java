package com.ba.yzl3514.gui;

import javax.swing.*;

/**
 * Aşağıdaki kod java swing kütüphanesi ile
 * bir frame oluşturur.
 *
 * @author Onder Sahin
 *
 */
public class DriverFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Hello JFrame");
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
