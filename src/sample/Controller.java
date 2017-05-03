package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {
    public void pressAnyButton(MouseEvent event){
        System.out.println("Hello World");
    }

    @FXML
    private ImageView imgView;

    @FXML
    public void handleMouseClick(MouseEvent arg0) {
        System.out.println("clicked");
    }

}
