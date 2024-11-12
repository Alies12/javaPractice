package com.javafx.demofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondController {
    @FXML
    private Label lId;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfHost;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfAddres;

    @FXML
    protected void setData(Reader reader){
        lId.setText(String.valueOf(reader.getId()));
        tfName.setText(reader.getName());
        tfHost.setText(reader.getHost());
        tfPassword.setText(reader.getPassword());
        tfAddres.setText(reader.getAddres());
    }

    @FXML
    protected void saveData(Reader reader) {
            tfName.setText(reader.getName());
            tfHost.setText(reader.getHost());
            tfPassword.setText(reader.getPassword());
            tfAddres.setText(reader.getAddres());
        }
        // sql query to update
    @FXML
    protected  void saveData() {

    }
}
