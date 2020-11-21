package main.java;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {

    public static void main(String[] args) throws UnirestException {
       Model model = new main.java.Model();
       Controller controller = new Controller(model);
       MyFrame frame = new main.java.MyFrame(controller);
    }
}
