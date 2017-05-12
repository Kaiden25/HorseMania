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
    /*Opens startscreen / splashscreen and sets variables*/
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
        wager = 100;
    }

    /*Properties*/
    private static Stage PrimaryStage;

    private static int currentMoney = 1000;
    private static int moneyOnBank = 2000;
    private static String stats1;
    private static String stats2;
    private static int wager;

    @FXML private TextField moneyToDeposit;
    @FXML private Label moneyOnBankLabel;
    @FXML private Label currentMoneyLabel;
    @FXML private Label statsLabel1;
    @FXML private Label statsLabel2;

    /*Main method*/
    public static void main(String[] args) {
        launch(args);
    }

    /*Functions*/

    @FXML
    /*This sets race_selection as current scene*/
    public void goToRaceSelection(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("race_selection.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection1(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(100);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection2(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(200);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection3(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(300);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection4(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(400);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection5(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(500);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection6(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(600);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection7(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(700);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection8(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(800);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets horse_selection as current scene and deduces your wager from current money*/
    public void goToHorseSelection9(Event arg0) {
        // set the wager to the race corrresponding amount
        setWager(900);
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("horse_selection.fxml")), 900, 600));
        }
        catch (Exception ex){}
    }

    @FXML
    /*This sets settings as current scene*/
    public void goToSettings(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("settings.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets bank as current scene*/
    public void goToBank(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("bank.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets settings as current scene*/
    public void goToStats(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("statistic.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This method is used when a horse gets selected
    * This method evaluates if the selected horse has won, adds money horse has won,
    * and sets the current scene back to the race_selection*/
    public void selectHorse(Event arg0){
        // Get a random number between 1 and 100
        int random = (int)(Math.random()*100);
        // See i random number is above 50, if it is you win
        if(random > 50){
            JOptionPane.showMessageDialog(null, "The Horse you selected has won", "Your Horse won!!!", JOptionPane.INFORMATION_MESSAGE);
            // Checks if wager is set if it isn't wager is set to 100
            if (wager == 0){
                setWager(100);
            }
            // Add payout at odds of 1:2 to currentMoney
            currentMoney = (currentMoney + (wager * 2));
            currentMoneyLabel.setText(String.valueOf(currentMoney));
            addStats("Bet won", "+ " + String.valueOf(wager));
            wager = 0;
        }
        else{
            //Message on loss
            addStats("Bet lost", "- " + String.valueOf(wager));
            JOptionPane.showMessageDialog(null, "The Horse you selected has lost", "Your Horse lost", JOptionPane.INFORMATION_MESSAGE);
        }
        //Adds a little bit of money to the bank. (Positive interest)
        moneyOnBank = moneyOnBank * 105 / 100;
        //Sets scene to race_selection
        goToRaceSelection(null);
    }

    @FXML
    /*This method deposites the entered amount into bank*/
    public void depositMoney(Event arg0){
        try {
            Integer i = Integer.parseInt(moneyToDeposit.getText());
            if(currentMoney < i)
                //Message if you try to deposite more than you own
                JOptionPane.showMessageDialog(null, "Sorry, but you don't have that much money to deposit...", "You don't have that much money", JOptionPane.INFORMATION_MESSAGE);
            else{
                //The deposit calculation and massage on successful deposit
                moneyOnBank = moneyOnBank + i;
                currentMoney = currentMoney - i;
                currentMoneyLabel.setText(String.valueOf(currentMoney));
                moneyOnBankLabel.setText(String.valueOf(moneyOnBank));
                addStats("Deposited money:", "- " + String.valueOf(i));
            }
        }
        catch (Exception ex){
            //Message if you deposit without entering a value
            JOptionPane.showMessageDialog(null, "Please just enter full numbers", "Incorrect input", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    /*This method withdraws the entered amount into bank*/
    public void withdrawMoney(Event arg0){
        try {
            Integer i = Integer.parseInt(moneyToDeposit.getText());
            if(moneyOnBank < i)
                //Message if you try to withdraw more than you own
                JOptionPane.showMessageDialog(null, "Sorry, but you don't have that much money to withdraw...", "You don't have that much money", JOptionPane.INFORMATION_MESSAGE);
            else{
                //The withdrawal calculation and massage on successful deposit
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
    /*This method initializes current money, money in bank and the corresponding labels*/
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

    //This method adds the stats to the statistic
    private void addStats(String key, String value){
        stats1 = stats1 + "\n" + key;
        stats2 = stats2 + "\n" + value;
    }

    /*This method plays music
    * Not implemented right now, but can be implemented if wished
    * Currently just an idea*/
    private void playMusic(){
        File f = new File("Soundtrack/Theme.mp3");
        if(f.exists()){
            Media hit = new Media(f.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        }
    }

    /* This setter sets wager */
    public void setWager(int wager) {
        this.wager = wager;
        //Removes current wager / bet from money
        currentMoney = currentMoney - wager;
    }
}
