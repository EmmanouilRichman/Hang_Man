package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {
    Controller controller;
    JTextField userInput;
    JLabel answerLabel;
    char toCheck;

    public MyFrame(Controller controller) {
        this.controller = controller;
        userInput = new JTextField();
        answerLabel = new JLabel(" ", SwingConstants.CENTER);
        init();
    }

    public void init() {
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Hangman");

        userInput.setEditable(false);
        controller.setLayout(new BorderLayout());
        controller.add(answerLabel, BorderLayout.NORTH);
        controller.add(userInput, BorderLayout.SOUTH);
        answerLabel.setText(controller.getModel().getToShow());
        addKeyListener(listener);
        add(controller);
        setVisible(true);
        setFocusable(true);
    }

    KeyListener listener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int code = keyEvent.getKeyCode();
            String guess = keyEvent.getKeyText(code);
            guess = guess.toLowerCase();
            userInput.setText(guess);
            if(code == KeyEvent.VK_ENTER){
                System.out.println(toCheck);
                userInput.setText("");
                if(controller.model.checkIfExists(toCheck)){
                    controller.model.upDateToShow(toCheck);
                    answerLabel.setText(controller.getModel().getToShow());
                }
                else{
                    controller.getAmountWrong();
                    controller.repaint();
                }
            }
            else{
                toCheck = guess.charAt(0);
            }

            if(code == KeyEvent.VK_R){
                controller.getModel().setToShow();
                controller.setAmountWrong();
                answerLabel.setText(controller.getModel().getToShow());
                userInput.setText("");
                repaint();
            }

            if(controller.getModel().getToShow().equals(controller.getModel().getAnswer())){
                answerLabel.setText("You win!");
            }
            else if(controller.getAmount() == 6){
                answerLabel.setText("You Lose!");
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    };

}
