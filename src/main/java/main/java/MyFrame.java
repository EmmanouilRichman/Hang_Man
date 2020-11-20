package main.java;

import com.mashape.unirest.http.exceptions.UnirestException;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Controller controller;
    JTextField userInput;
    JLabel answerLabel;

    public MyFrame(Controller controller) {
        this.controller = controller;
        userInput = new JTextField();
        answerLabel = new JLabel(" ", SwingConstants.CENTER);
        init();
    }

    public void init() {
        this.setSize(420, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Hangman");

        controller.setLayout(new BorderLayout());
        controller.add(answerLabel, BorderLayout.NORTH);
        controller.add(userInput, BorderLayout.SOUTH);
        answerLabel.setText(controller.getModel().getToShow());

        this.add(controller);
        setVisible(true);
    }

}
