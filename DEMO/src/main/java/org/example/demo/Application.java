package org.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.demo.Utils.DBConnect.SignletonConnexionDB;
import org.example.demo.Views.DepView;
import org.example.demo.Views.ProfView;

import java.sql.Connection;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        Connection connection= SignletonConnexionDB.getConnection();
        ProfView profView = new ProfView();
        DepView depView = new DepView();
        TabPane tabPane = new TabPane(profView.getTab(),depView.getTab());
        // Create a Scene
        Scene scene = new Scene(tabPane, 800, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
