package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

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
        currentMoneyLabel = new Label();
        currentMoneyLabel.setText("345");
    }

    /*Properties*/
    private static Stage PrimaryStage;

    private int currentMoney = 1000;

    @FXML private TextField moneyToDeposit;
    @FXML private Label currentMoneyLabel;

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
    public void selectHorse(Event arg0){
        //Show Dialog horse selected
        JOptionPane.showMessageDialog(null, "You selected a Horse", "Horse selected!", JOptionPane.INFORMATION_MESSAGE);
        goToRaceSelection(null);
    }

    @FXML
    public void depositMoney(Event arg0){
        //Show Dialog horse selected
        //JOptionPane.showMessageDialog(null, moneyToDeposit.getText(), "Money Disposited", JOptionPane.INFORMATION_MESSAGE);
        currentMoneyLabel.setText(moneyToDeposit.getText());
    }

    @FXML
    private void initialize(){
        if(currentMoneyLabel != null)
            currentMoneyLabel.setText(String.valueOf(currentMoney));
    }
}
