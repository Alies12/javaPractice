package com.javafx.demofx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class HelloController {
    @FXML
    private Button btnOk;

    @FXML
    private TableView<Reader> vReader;

    @FXML
    private TableColumn<Reader, String> cName;

    @FXML
    private TableColumn<Reader, String> cHost;

    @FXML
    private TableColumn<Reader, String> cPssword;

    @FXML
    private TableColumn<Reader, Date> cAddres;

    @FXML
    protected void changeButtonText() throws IOException {



        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("second.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Save");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void initialize() {
        vReader.setStyle("-fx-selection-bar: #67BA80; -fx-selection-bar-non-focused: #67BA80;");
        cName.setCellValueFactory(new PropertyValueFactory<Reader, String>("name"));
        cHost.setCellValueFactory(new PropertyValueFactory<Reader, String>("host"));
        cPssword.setCellValueFactory(new PropertyValueFactory<Reader, String>("password"));
        cAddres.setCellValueFactory(new PropertyValueFactory<Reader, Date>("addres"));
        vReader.setRowFactory(tv -> {
            TableRow<Reader> row = new TableRow<>();
            row.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getClickCount() == 2 && mouseEvent.getButton() == MouseButton.PRIMARY) {
                    Reader rowData = row.getItem();
                    Stage stage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("second.fxml"));
                    try {
                        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
                        SecondController secondController = fxmlLoader.getController();
                        secondController.setData(rowData);
                        stage.setTitle("Reader edit..");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            return row;
        });
    }

    @FXML
    protected void updateData(ObservableList<Reader> readers) {
        vReader.setItems(readers);
    }

    @FXML
    protected void saveChanges() {
        ReaderDAO readerDAO = new ReaderDAO();
//        readerDAO.update(id)
    }


}