package org.example.demo.Views;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DepView {
    TabPane tabPane;
    Tab DepTab;
    TableView<Object> TableDep;
    TableColumn<Object,String> ColumnIdDep;
    TableColumn<Object,String> ColumnNomDep;

    Button AddDepBtn;
    Button DeleteDepBtn;
    Button UpdateDepBtn;
    HBox OperationsDepHbox;
    BorderPane borderPaneDep;
    DepInfoForum depInfoForum;

    public DepView() {
        depInfoForum = new DepInfoForum();
        tabPane = new TabPane();
        borderPaneDep = new BorderPane();
        DepTab = new Tab("Departements");
        AddDepBtn = new Button("Add");
        AddDepBtn.setOnAction(ActionEvent -> depInfoForum.show());
        UpdateDepBtn = new Button("Update");
        DeleteDepBtn = new Button("Delete");
        OperationsDepHbox = new HBox(10);
        TableDep = new TableView<>();
        ColumnIdDep= new TableColumn<>("Id_Depart");
        ColumnNomDep = new TableColumn<>("Nom");
        TableDep.getColumns().addAll(ColumnIdDep,ColumnNomDep);
        OperationsDepHbox.setPadding(new Insets(7,10,7,10));
        OperationsDepHbox.getChildren().addAll(AddDepBtn,DeleteDepBtn,UpdateDepBtn);
        borderPaneDep.setPadding(new Insets(30,0,0,0));
        // Set the background to black
        borderPaneDep.setStyle("-fx-background-color:black");
        borderPaneDep.setCenter(TableDep);
        borderPaneDep.setBottom(OperationsDepHbox);
        // Add BorderPane to the Prof tab
        DepTab.setContent(borderPaneDep);
    }
    public Tab getTab() {
        return DepTab;
    }
}
