package main.java;

import com.mashape.unirest.http.exceptions.UnirestException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {
    private Controller controller;
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

        getController().setLayout(new BorderLayout());
        getController().add(answerLabel, BorderLayout.NORTH);
        getController().add(userInput, BorderLayout.SOUTH);
        answerLabel.setText(getController().getModel().getToShow());
        addKeyListener(listener);
        add(getController());

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
            String guess = KeyEvent.getKeyText(code);
            guess = guess.toLowerCase();
            userInput.setText(guess);
            if(code == KeyEvent.VK_ENTER){
                System.out.println(toCheck);
                userInput.setText("");
                if(getController().getModel().checkIfExists(toCheck)){
                    getController().getModel().upDateToShow(toCheck);
                    answerLabel.setText(controller.getModel().getToShow());
                }
                else{
                    getController().getAmountWrong();
                    getController().repaint();
                }
            }
            else{
                toCheck = guess.charAt(0);
            }

            if(code == KeyEvent.VK_1){
                getController().setAmountWrong();
                try {
                    getController().getModel().getWordToGuess();
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
                answerLabel.setText(getController().getModel().getToShow());
                repaint();
            }

            if(getController().getModel().getToShow().equals(getController().getModel().getAnswer())){
                answerLabel.setText("You win!");
            }
            else if(getController().getAmount() == 6){
                answerLabel.setText("You Lose!");
                userInput.setText(getController().getModel().getAnswer());
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    };

    public Controller getController(){
        return controller;
    }

}
