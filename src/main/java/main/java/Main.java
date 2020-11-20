package main.java;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {

    public static void main(String[] args) throws UnirestException {
       main.java.Model model = new main.java.Model();
       main.java.Controller controller = new Controller(model);
       main.java.MyFrame frame = new main.java.MyFrame(controller);
    }
}
