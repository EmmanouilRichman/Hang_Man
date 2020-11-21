package main.java;

import javax.swing.*;
import java.awt.*;

public class Controller extends JPanel {
    Model model;

    public Controller(main.java.Model model) {
        this.model = model;
    }
    int amountWrong = 0;

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(1));


        //Drawing the base
        g2D.drawLine(100, 50, 250, 50); // top line
        g2D.drawLine(100, 50, 100, 100); // top vertical line
        g2D.drawLine(250, 50, 250, 250); // y line right
        g2D.drawLine(180, 250, 300, 250); //bottom x line

        if (amountWrong >= 1) {
            //Drawing the Head
            g2D.drawOval(90, 100, 20, 20); // head
        }
        if (amountWrong >= 2)
            //Drawing the body
            g2D.drawLine(100, 119, 100, 170);

        if (amountWrong >= 3) {
            g2D.drawLine(60, 110, 100, 150);
        }
        if (amountWrong >= 4) {
            g2D.drawLine(140, 110, 100, 150);
        }
        if (amountWrong >= 5) {
            g2D.drawLine(100, 170, 70, 210);
        }
       if(amountWrong == 6){
            g2D.drawLine(100, 170, 130, 210);
        }

    }

    public void setAmountWrong() {amountWrong = 0;}

    public void getAmountWrong(){
        amountWrong = getModel().getAmountWrong();
    }

    public int getAmount(){return amountWrong;}

    public Model getModel() {
        return model;
    }

}
