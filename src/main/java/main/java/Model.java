package main.java;

import java.util.HashSet;
import java.net.URLEncoder;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Model {
    HashSet<Character> charactersInAnswer = new HashSet();
    String answer = "";
    String toShow = "";
    char guess;
    private int amountWrong = 0;

    public Model() throws UnirestException {
        getWordToGuess();
    }

    public void getWordToGuess() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://random-words2.p.rapidapi.com/words?limit=1&lang=en")
                .header("x-rapidapi-key", "714c5e9e9dmshaa95abb1d7dfcc0p1ba528jsn79ec9f6dddd5")
                .header("x-rapidapi-host", "random-words2.p.rapidapi.com")
                .asJson();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        JsonObject root = je.getAsJsonObject();
        String word = root.get("words").toString();
        this.answer = word.substring(2, word.length()- 2);
        setToShow();
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
