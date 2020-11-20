package main.java;

public class Main {

    public static void main(String[] args) {
       main.java.Model model = new main.java.Model();
       main.java.Controller controller = new Controller(model);
       main.java.MyFrame frame = new main.java.MyFrame(controller);
    }
}
