package com.javafx.demofx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ObservableList<Reader> readers = FXCollections.observableArrayList(
                new Reader(1, "Bob", "3000", "88005553535", "22223"),
                new Reader(2, "Ann", "3002", "911", "5543"),
                new Reader(3, "It", "3006", "0", "3000"),
                new Reader(4, "German", "3004", "4545454", "1111")
        );
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);

        HelloController helloController = fxmlLoader.getController();
        helloController.updateData(readers);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}