import java.util.HashSet;

public class Model {
    HashSet<Character> charactersInAnswer = new HashSet();
    String answer = "Hello";
    String toShow = "";
    private int amountWrong;

    public Model() {
        this.amountWrong = 0;
        setToShow();
        fillSet();
    }


    public void setThingToMatch() {

    }

    public boolean checkIfCharExists() {
        return true;
    }

    public int getAmountWrong() {
        return amountWrong;
    }

    public void setAmountWrong() {
        amountWrong++;
    }

    public void setToShow() {
        for (int i = 0; i < answer.length(); i++) {
            toShow += "_" + " ";
        }
    }

    public String getToShow() {
        return toShow;
    }

    public void fillSet() {
        for (int i = 0; i < answer.length(); i++) {
            charactersInAnswer.add(answer.charAt(i));
        }
    }
}
