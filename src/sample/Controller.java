package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.*;
import java.util.ArrayList;

public class Controller {
    @FXML
    private TextField myNumber1, myNumber2, myNumber3, myNumber4, myNumber5, myNumber6;
    @FXML
    private TextField winNumber1, winNumber2, winNumber3, winNumber4, winNumber5, winNumber6;
    @FXML
    private Label title;
    @FXML
    private Label results;
    private int[] myNumbers;
    private ArrayList<Integer> winNumbers;
    private int score;
    public void startGame(ActionEvent e){
        this.score=0;
        this.myNumbers = new int[]{Integer.parseInt(this.myNumber1.getText()), Integer.parseInt(this.myNumber2.getText()), Integer.parseInt(this.myNumber3.getText()), Integer.parseInt(this.myNumber4.getText()), Integer.parseInt(this.myNumber5.getText()), Integer.parseInt(this.myNumber6.getText())};
        this.winNumbers = new ArrayList(6);
        this.getWinNumbers();
        this.showWinNumbers();
        this.compareResults();
        this.showResults();
    }
    public void clearFields(){
        this.winNumber1.setText("");
        this.winNumber2.setText("");
        this.winNumber3.setText("");
        this.winNumber4.setText("");
        this.winNumber5.setText("");
        this.winNumber6.setText("");
        this.myNumber1.setText("");
        this.myNumber2.setText("");
        this.myNumber3.setText("");
        this.myNumber4.setText("");
        this.myNumber5.setText("");
        this.myNumber6.setText("");
        this.results.setText("Wyniki:");
    }
    public void getWinNumbers(){
        for(int i=0;i<6;i++) {
            int number = 0;
            for(;;) {
                number = (int) (Math.random() * 46 + 1);
                if(!this.winNumbers.contains(number)) break;
            }
            this.winNumbers.add(number);
        }
    }
    public void showWinNumbers(){
        this.winNumber1.setText(String.valueOf(this.winNumbers.get(0)));
        this.winNumber2.setText(String.valueOf(this.winNumbers.get(1)));
        this.winNumber3.setText(String.valueOf(this.winNumbers.get(2)));
        this.winNumber4.setText(String.valueOf(this.winNumbers.get(3)));
        this.winNumber5.setText(String.valueOf(this.winNumbers.get(4)));
        this.winNumber6.setText(String.valueOf(this.winNumbers.get(5)));
    }
    public void compareResults(){
        for(int i=0;i<6;i++){
            if(this.winNumbers.contains(this.myNumbers[i]))this.score++;
        }
    }
    public void showResults(){
        this.results.setText("Wyniki: " + String.valueOf(this.score) + " punktów");
    }
}
