package com.aniruddh.app;

import com.aniruddh.app.helpers.MongoHelper;
import com.aniruddh.app.models.SignUpModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aniruddh on 26-09-2017.
 */
public class NewEntry {
    private JPanel panelNew;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField AddressField;
    private JTextField dobField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    public NewEntry() {
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= new NewEntry().nameField.getText();
                String email = emailField.getText();
                String phone = phoneNumberField.getText();
                String address = AddressField.getText();
                String dob = dobField.getText();
                String pass = passwordField.getPassword().toString();
                SignUpModel signUp = new SignUpModel(name, email, address, dob, phone, pass);
                signUp.putRequest();
                JOptionPane.showMessageDialog(null, "Sign Up Complete");
            }
        });
    }

    public static void open() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        JFrame frame = new JFrame("New Entry");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setContentPane(new NewEntry().panelNew);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
