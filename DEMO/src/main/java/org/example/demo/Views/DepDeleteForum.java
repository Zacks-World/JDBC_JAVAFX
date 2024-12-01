package org.example.demo.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.demo.Controllers.DepController;
import org.example.demo.Models.Departement;

import java.sql.SQLException;

public class DepDeleteForum {
    Stage FormStage;
    DepController depController;
    Scene Formscene;
    GridPane FormLayout;
    HBox OperationsLayout;
    Button SaveBtn;
    TextField IdField;
    Label IdLabel;
    Departement Dep;
    public DepDeleteForum(){
        Dep = new Departement();
        depController= new DepController();
        FormLayout = new GridPane();
        SaveBtn =new Button("Delete");
        SaveBtn.setPadding(new Insets(10,7,10,7));
        SaveBtn.setOnAction(ActionEvent-> {
            try {
                depController.addDep(IdField.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        OperationsLayout = new HBox(10,SaveBtn);
        FormLayout.setHgap(10);
        FormLayout.setVgap(10);
        FormLayout.setPadding(new Insets(30,30,30,30));
        IdField = new TextField();
        IdLabel = new Label("Nom");
        FormLayout.addRow(0,IdLabel);
        FormLayout.addRow(1,IdField);
        FormLayout.addRow(8,OperationsLayout);
        Formscene = new Scene(FormLayout);
        FormStage = new Stage();
        FormStage.setScene(Formscene);
    }
    public void show(){
        FormStage.show();
    }
}
