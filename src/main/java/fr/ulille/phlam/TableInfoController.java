package fr.ulille.phlam;

import fr.ulille.phlam.entities.Datatable;
import fr.ulille.phlam.entities.Format;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.persistence.*;
import java.io.File;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TableInfoController implements Initializable {

    @FXML
    ComboBox<String> formatCombo;
    @FXML
    TextField nameField;
    @FXML
    TextField pathField;
    @FXML
    Button openFileButton;
    @FXML
    Button compileButton;

    FileChooser fileChooser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EntityManager entityManager = MainApp.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery("select f from Format f");
        List<Format> formats = query.getResultList();
        List<String> names = formats.stream().map(f->f.getName()).collect(Collectors.toList());
        formatCombo.getItems().clear();
        if (names.size()>0){
            formatCombo.getItems().addAll(names);
            formatCombo.getSelectionModel().selectFirst();
        }
        entityManager.close();


        Color coral = Color.color(1,0.4,0.3,0.5);
        Background errorBackground =
                new Background(new BackgroundFill(coral,null,null));
        Background normalBackground =
                new Background(new BackgroundFill(Color.WHITE,null,null));

        nameField.textProperty().addListener(((observable, oldValue, newValue) -> {
            MainApp.getMainController().tableInfoStage.setTitle("Table - "+newValue);
            nameField.setBackground(normalBackground);
        }));

        pathField.textProperty().addListener(((observable, oldValue, newValue) -> {
            pathField.setBackground(normalBackground);
        }));

        fileChooser = new FileChooser();
        openFileButton.setOnAction(e->{
            File file = fileChooser.showOpenDialog(MainApp.getMainController().tableViewStage);
            if (file!=null){
                pathField.setText(file.getPath());
            }
        });

        compileButton.setOnAction(e->{
            if (nameField.getText().isEmpty()||pathField.getText().isEmpty()){
                if (nameField.getText().isEmpty()) nameField.setBackground(errorBackground);
                if (pathField.getText().isEmpty()) pathField.setBackground(errorBackground);
                return;
            }

            Datatable datatable = new Datatable();
            datatable.setName(nameField.getText());
            datatable.setPath(pathField.getText());
            datatable.setDate(new Timestamp(System.currentTimeMillis()));
            EntityManager em1 = MainApp.getEntityManagerFactory().createEntityManager();
            TypedQuery<Format> query1 = em1.createQuery("select f from Format f where f.id = :id",Format.class);
            query1.setParameter("id",(long) formatCombo.getSelectionModel().getSelectedIndex()+1);
            Format f = query1.getSingleResult();
            datatable.setFormat(f);
            em1.getTransaction().begin();
            em1.persist(datatable);
            em1.getTransaction().commit();
            em1.close();
        });
    }
}
