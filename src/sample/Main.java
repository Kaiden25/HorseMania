package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;

/**
 * Main Class.
 * Serves as the Controller for the whole application.
 * **/
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Horse Simulator");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
        PrimaryStage = primaryStage;
        stats1 = "Start:";
        stats2 = String.valueOf(currentMoney);
    }

    /*Properties*/
    private static Stage PrimaryStage;

    private static int currentMoney = 1000;
    private static int moneyOnBank = 2000;
    private static String stats1;
    private static String stats2;

    @FXML private TextField moneyToDeposit;
    @FXML private Label moneyOnBankLabel;
    @FXML private Label currentMoneyLabel;
    @FXML private Label statsLabel1;
    @FXML private Label statsLabel2;


    public static void main(String[] args) {
        launch(args);
    }

    /*Functions*/
    @FXML
    public void goToRaceSelection(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("race_selection.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    public void goToHorseSelection(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    public void goToSettings(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("settings.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    public void goToBank(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("bank.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    public void goToStats(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("statistic.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    public void selectHorse(Event arg0){
        //Show Dialog horse selected
        JOptionPane.showMessageDialog(null, "You selected a Horse", "Horse selected!", JOptionPane.INFORMATION_MESSAGE);
        goToRaceSelection(null);
        int random = (int)(Math.random()*100);
        if(random > 50){
            JOptionPane.showMessageDialog(null, "The Horse you selected has won", "Your Horse won!!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    public void depositMoney(Event arg0){
        try {
            Integer i = Integer.parseInt(moneyToDeposit.getText());
            if(currentMoney < i)
                JOptionPane.showMessageDialog(null, "Sorry, but you don't have that much money to deposit...", "You don't have that much money", JOptionPane.INFORMATION_MESSAGE);
            else{
                moneyOnBank = moneyOnBank + i;
                currentMoney = currentMoney - i;
                currentMoneyLabel.setText(String.valueOf(currentMoney));
                moneyOnBankLabel.setText(String.valueOf(moneyOnBank));
                addStats("Deposited money:", "- " + String.valueOf(i));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Please just enter full numbers", "Incorrect input", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    public void withdrawMoney(Event arg0){
        try {
            Integer i = Integer.parseInt(moneyToDeposit.getText());
            if(moneyOnBank < i)
                JOptionPane.showMessageDialog(null, "Sorry, but you don't have that much money to withdraw...", "You don't have that much money", JOptionPane.INFORMATION_MESSAGE);
            else{
                currentMoney = currentMoney + i;
                moneyOnBank = moneyOnBank - i;
                currentMoneyLabel.setText(String.valueOf(currentMoney));
                moneyOnBankLabel.setText(String.valueOf(moneyOnBank));
                addStats("Withdrawn money:", "+ " + String.valueOf(i));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Please just enter full numbers", "Incorrect input", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void initialize(){
        if(currentMoneyLabel != null)
            currentMoneyLabel.setText(String.valueOf(currentMoney));
        else playMusic();
        if(moneyOnBankLabel != null)
            moneyOnBankLabel.setText(String.valueOf(moneyOnBank));
        if(statsLabel1 != null)
            statsLabel1.setText(stats1);
        if(statsLabel2 != null)
            statsLabel2.setText(stats2);
    }

    private void addStats(String key, String value){
        stats1 = stats1 + "\n" + key;
        stats2 = stats2 + "\n" + value;
    }

    private void playMusic(){
        File f = new File("Soundtrack/Theme.mp3");
        if(f.exists()){
            Media hit = new Media(f.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        }
    }
}
