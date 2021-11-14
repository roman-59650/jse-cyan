package fr.ulille.phlam;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Stage tableViewStage;
    public Stage tableInfoStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableViewStage = new Stage();
        tableInfoStage = new Stage();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("table_view.fxml"));
            Parent tools = fxmlLoader.load();
            tableViewStage.setScene(new Scene(tools));
            tableViewStage.initModality(Modality.NONE);
            tableViewStage.initStyle(StageStyle.DECORATED);
            tableViewStage.setTitle("Predicted Spectra");
            tableViewStage.setResizable(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("new_table.fxml"));
            Parent tools = fxmlLoader.load();
            tableInfoStage.setScene(new Scene(tools));
            tableInfoStage.initModality(Modality.WINDOW_MODAL);
            tableInfoStage.initStyle(StageStyle.UTILITY);
            tableInfoStage.setTitle("Table - ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onTablesClick(ActionEvent e){
        tableViewStage.show();
    }
}
