package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private ImageView startImgView;

    @FXML
    public void goToFirstScreen(MouseEvent arg0) {
        System.out.println("clicked");
    }
}
