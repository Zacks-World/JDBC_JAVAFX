package org.example.demo.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.example.demo.Controllers.ProfController;
import org.example.demo.Models.Professeur;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public class ProfView {
    Tab profTab;
    ProfController profController;
    BorderPane BorderPaneProf;
    HBox SearchHboxProf;
    HBox OperationsProfHbox = new HBox(10);
    TableView<Object> TableProf;
    String[] ColumnNames = {"id_prof","nom","prenom","cin","adresse","email","telephone","date_recrutement"};
    TextField SearchBar;
    Button SearchProfBtn;
    Button AddProfBtn;
    Button DeleteProfBtn;
    Button UpdateProfBtn;
    ProfInfoForum profinfoforum;
    ProfInfoForumUpdate profinfoforumupdate;
    ProfDeleteView profDeleteView;


    public ProfView() {
        profinfoforum = new ProfInfoForum();
        profDeleteView = new ProfDeleteView();
        profinfoforumupdate = new ProfInfoForumUpdate();
        profController = new ProfController();
        AddProfBtn = new Button("Add");
        AddProfBtn.setOnAction(actionEvent -> profinfoforum.show());
        DeleteProfBtn = new Button("Delete");
        UpdateProfBtn = new Button("Update");
        UpdateProfBtn.setOnAction(actionEvent -> profinfoforumupdate.show());
        DeleteProfBtn.setOnAction(actionEvent -> profDeleteView.show());
        profTab = new Tab("Professeurs");
        BorderPaneProf = new BorderPane();
        SearchHboxProf = new HBox(10);
        OperationsProfHbox = new HBox(10);
        SearchBar = new TextField();
        SearchBar.setPrefWidth(250);
        SearchBar.setPadding(new Insets(7,10,7,10));
        SearchProfBtn = new Button("Search");
        SearchProfBtn.setPadding(new Insets(7,10,7,10));
        SearchHboxProf.setAlignment(Pos.CENTER);
        SearchHboxProf.setPadding(new Insets(10,0,10,0));
        SearchHboxProf.getChildren().addAll(SearchBar,SearchProfBtn);
        OperationsProfHbox.setPadding(new Insets(7,10,7,10));
        OperationsProfHbox.getChildren().addAll(AddProfBtn,DeleteProfBtn,UpdateProfBtn);
        profTab.setContent(BorderPaneProf);
        TableProf = new TableView<>();
        for (int i = 0; i <ColumnNames.length ; i++) {
            TableColumn Column = new TableColumn<>(ColumnNames[i]);
            Column.setCellValueFactory(new PropertyValueFactory<>(ColumnNames[i]));
            TableProf.getColumns().addAll(Column);
        }

        SearchHboxProf.setStyle("-fx-background-color: pink;");
        BorderPaneProf.setStyle("-fx-background-color: black;");
        BorderPaneProf.setTop(SearchHboxProf);
        BorderPaneProf.setCenter(TableProf);
        BorderPaneProf.setBottom(OperationsProfHbox);
        profTab.setContent(BorderPaneProf);
    }
    public Tab getTab() {
        return profTab;
    }

}
