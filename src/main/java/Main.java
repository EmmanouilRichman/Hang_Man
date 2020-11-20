public class Main {

    public static void main(String[] args) {
       Model model = new Model();
       Controller controller = new Controller(model);
       MyFrame frame = new MyFrame(controller);
    }
}
