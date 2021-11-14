package fr.ulille.phlam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp extends Application {

    private Stage primaryStage;
    private static MainController mainController;
    private static EntityManagerFactory entityManagerFactory;

    @Override
    public void start(Stage primaryStage) throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("llama");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        mainController = loader.getController();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        this.primaryStage = primaryStage;
        mainController.tableViewStage.initOwner(primaryStage);
        mainController.tableInfoStage.initOwner(mainController.tableViewStage);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static void main(String[] args){
        launch(args);
    }
}
