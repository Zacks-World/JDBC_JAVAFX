package org.example.demo.Views;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.demo.Controllers.ProfController;
import org.example.demo.Models.Professeur;

import java.sql.Date;
import java.sql.SQLException;
import java.text.Normalizer;

public class ProfDeleteView {
    Stage FormStage;
    ProfController profController;
    Scene Formscene;
    GridPane FormLayout;
    HBox OperationsLayout;
    Button DeleteBtn;
    TextField IdField;
    Label IdLabel;

    public ProfDeleteView(){
        profController= new ProfController();
        FormLayout = new GridPane();
        DeleteBtn =new Button("Delete");
        DeleteBtn.setPadding(new Insets(10,7,10,7));
        DeleteBtn.setOnAction(ActionEvent-> {
            try {
                profController.DeleteProfessor(Integer.parseInt(IdField.getText()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        OperationsLayout = new HBox(10,DeleteBtn);
        FormLayout.setHgap(10);
        FormLayout.setVgap(10);
        FormLayout.setPadding(new Insets(30,30,30,30));
        IdField = new TextField();
        IdLabel = new Label("Id");
        FormLayout.addRow(0,IdLabel);
        FormLayout.addRow(1,IdField);
        FormLayout.addRow(2,OperationsLayout);
        Formscene = new Scene(FormLayout);
        FormStage = new Stage();
        FormStage.setScene(Formscene);
    }
    public void show(){
        FormStage.show();
    }
}