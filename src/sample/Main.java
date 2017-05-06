package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
       // Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("race_selection.fxml"));
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
    private int wager;

    @FXML private TextField moneyToDeposit;
    @FXML private Label moneyOnBankLabel;
    @FXML private Label currentMoneyLabel;
    @FXML private Label statsLabel1;
    @FXML private Label statsLabel2;
    @FXML private GridPane wager1;
    @FXML private GridPane wager2;
    @FXML private GridPane wager3;
    @FXML private GridPane wager4;
    @FXML private GridPane wager5;
    @FXML private GridPane wager6;
    @FXML private GridPane wager7;
    @FXML private GridPane wager8;
    @FXML private GridPane wager9;


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
        currentMoney = currentMoney - wager();
        currentMoneyLabel.setText(String.valueOf(currentMoney));
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
        // Get a random number between 1 and 100
        int random = (int)(Math.random()*100);
        // See i random number is above 50, if it is you win
        if(random > 50){
            JOptionPane.showMessageDialog(null, "The Horse you selected has won", "Your Horse won!!!", JOptionPane.INFORMATION_MESSAGE);
            // Add payout at odds of 1:2 to currentMoney
            currentMoney = currentMoney + (wager * 2);
            currentMoneyLabel.setText(String.valueOf(currentMoney));
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

    public int wager(){
        if (wager1 != null) {
            setWager(100);
            if (wager2 != null) {
                setWager(200);
                if (wager3 != null) {
                    setWager(300);
                    if (wager4 != null) {
                        setWager(400);
                        if (wager5 != null) {
                            setWager(500);
                            if (wager6 != null) {
                                setWager(600);
                                if (wager7 != null) {
                                    setWager(700);
                                    if (wager8 != null) {
                                        setWager(800);
                                        if (wager9 != null) {
                                            setWager(900);
                                        }
                                        return wager;
                                    }
                                    return wager;
                                }
                                return wager;
                            }
                            return wager;
                        }
                        return wager;
                    }
                    return wager;
                }
                return wager;
            }
            return wager;
        }
        return wager;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }
}
