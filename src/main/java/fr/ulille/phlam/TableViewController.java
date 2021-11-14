package fr.ulille.phlam;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    Button newTableButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newTableButton.setOnAction(e->{
            MainApp.getMainController().tableInfoStage.show();
        });
    }

}
