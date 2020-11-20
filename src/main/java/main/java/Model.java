package main.java;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashSet;

public class Model {
    HashSet<Character> charactersInAnswer = new HashSet();
    String answer = "emmanouil";
    String toShow = "";
    char guess;
    private int amountWrong = 0;

    public Model() throws UnirestException {
//        getWordToGuess();
        setToShow();
    }

    public void getWordToGuess() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://random-words2.p.rapidapi.com/words?limit=1&lang=en")
                .header("x-rapidapi-key", "")
                .header("x-rapidapi-host", "random-words2.p.rapidapi.com")
                .asJson();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        JsonObject root = je.getAsJsonObject();
        String word = root.get("words").toString();
        this.answer = word.substring(2, word.length() - 2);
        setToShow();
    }

    public int getAmountWrong() {
        return amountWrong;
    }

    public void upDateToShow(char c){
        String replacement = "";
        for(int i = 0; i < answer.length(); i++){
            if(answer.charAt(i) == c){
                replacement += c;
            }
            else if(toShow.charAt(i) != '_'){
                replacement += toShow.charAt(i);
            }
            else{
                replacement += "_";
            }
        }
        toShow = replacement;
    }

    public char getGuess() {
        return this.guess;
    }

    public void setGuess(char c) {
        this.guess = c;
    }

    public String getToShow() {
        return toShow;
    }
    
     public void setToShow() {
        for (int i = 0; i < answer.length(); i++) {
            charactersInAnswer.add(answer.charAt(i));
            toShow += "_";
        }
    }
    
     public void setAmountWrong() {
        amountWrong++;
    }

    public boolean checkIfExists(char c){
        setGuess(c);
        if(charactersInAnswer.contains(getGuess())){
            return true;
        }
        else{
            amountWrong++;
            return false;
        }
    }

}
