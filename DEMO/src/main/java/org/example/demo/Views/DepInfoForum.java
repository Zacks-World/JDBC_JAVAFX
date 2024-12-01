package org.example.demo.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.demo.Controllers.DepController;
import org.example.demo.Controllers.ProfController;
import org.example.demo.Models.Departement;
import org.example.demo.Models.Professeur;

import java.sql.Date;
import java.sql.SQLException;

public class DepInfoForum {
    Stage FormStage;
    DepController depController;
    Scene Formscene;
    GridPane FormLayout;
    HBox OperationsLayout;
    Button SaveBtn;
    TextField NomField;
    Label NomLabel;
    Departement Dep;
    public DepInfoForum(){
        Dep = new Departement();
        depController= new DepController();
        FormLayout = new GridPane();
        SaveBtn =new Button("Save");
        SaveBtn.setPadding(new Insets(10,7,10,7));
        SaveBtn.setOnAction(ActionEvent-> {
            try {
                depController.addDep(NomField.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        OperationsLayout = new HBox(10,SaveBtn);
        FormLayout.setHgap(10);
        FormLayout.setVgap(10);
        FormLayout.setPadding(new Insets(30,30,30,30));
        NomField = new TextField();
        NomLabel = new Label("Nom");
        FormLayout.addRow(0,NomLabel);
        FormLayout.addRow(1,NomField);
        FormLayout.addRow(8,OperationsLayout);
        Formscene = new Scene(FormLayout);
        FormStage = new Stage();
        FormStage.setScene(Formscene);
    }
    public void show(){
        FormStage.show();
    }
}
