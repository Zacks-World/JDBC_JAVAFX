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

public class ProfInfoForum {
    Stage FormStage;
    ProfController profController;
    Scene Formscene;
    GridPane FormLayout;
    HBox OperationsLayout;
    Button SaveBtn;
    Button ResetBtn;
    TextField NomField;
    TextField PrenomField;
    TextField CinField;
    TextField AdresseField;
    TextField TelephoneField;
    TextField EmailField;
    DatePicker DateRecrutementPicker;
    Label NomLabel;
    Label PrenomLabel;
    Label CinLabel;
    Label AdresseLabel;
    Label TelephoneLabel;
    Label EmailLabel;
    Label DateRecrutementLabel;
    Professeur Prof;

    public ProfInfoForum(){
        Prof = new Professeur();
        profController= new ProfController();
        FormLayout = new GridPane();
        SaveBtn =new Button("Save");
        ResetBtn =new Button("Reset");
        SaveBtn.setPadding(new Insets(10,7,10,7));
        ResetBtn.setPadding(new Insets(10,7,10,7));
        SaveBtn.setOnAction(ActionEvent-> {
            try {
                profController.addProfessor(NomField.getText(),PrenomField.getText(),CinField.getText(),AdresseField.getText(),TelephoneField.getText(),EmailField.getText(), Date.valueOf(DateRecrutementPicker.getValue()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        ResetBtn.setOnAction(ActionEvent->profController.ProfReset(NomField,PrenomField,CinField,AdresseField,TelephoneField,EmailField,DateRecrutementPicker));
        OperationsLayout = new HBox(10,SaveBtn,ResetBtn);
        FormLayout.setHgap(10);
        FormLayout.setVgap(10);
        FormLayout.setPadding(new Insets(30,30,30,30));
        NomField = new TextField();
        PrenomField = new TextField();
        CinField = new TextField();
        TelephoneField = new TextField();
        AdresseField = new TextField();
        EmailField = new TextField();
        DateRecrutementPicker = new DatePicker();
        NomLabel = new Label("Nom");
        PrenomLabel =new Label("Prenom");
        CinLabel =new Label("Prenom");
        AdresseLabel =new Label("Adresse");
        TelephoneLabel =new Label("Telephone");
        EmailLabel =new Label("Email");
        DateRecrutementLabel = new Label("Date Recrutement");
        FormLayout.addRow(0,NomLabel,PrenomLabel);
        FormLayout.addRow(1,NomField,PrenomField);
        FormLayout.addRow(2,CinLabel,AdresseLabel);
        FormLayout.addRow(3,CinField,AdresseField);
        FormLayout.addRow(4,EmailLabel,TelephoneLabel);
        FormLayout.addRow(5,EmailField,TelephoneField);
        FormLayout.addRow(6,DateRecrutementLabel);
        FormLayout.addRow(7,DateRecrutementPicker);
        FormLayout.addRow(8,OperationsLayout);

        Formscene = new Scene(FormLayout);
        FormStage = new Stage();
        FormStage.setScene(Formscene);
    }
    public void show(){
        FormStage.show();
    }
}
