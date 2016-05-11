package it.polito.tdp.porto.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> cmbAutore1;

    @FXML
    private ComboBox<?> cmbAutore2;

    @FXML
    private Button btnCoautori;

    @FXML
    private Button btnCluster;

    @FXML
    private Button btnArticoli;

    @FXML
    private TextArea txtOutput;

    @FXML
    void doArticoli(ActionEvent event) {

    }

    @FXML
    void doCluster(ActionEvent event) {

    }

    @FXML
    void doCoautori(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cmbAutore1 != null : "fx:id=\"cmbAutore1\" was not injected: check your FXML file 'Porto.fxml'.";
        assert cmbAutore2 != null : "fx:id=\"cmbAutore2\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnCoautori != null : "fx:id=\"btnCoautori\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnCluster != null : "fx:id=\"btnCluster\" was not injected: check your FXML file 'Porto.fxml'.";
        assert btnArticoli != null : "fx:id=\"btnArticoli\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Porto.fxml'.";

    }
}
