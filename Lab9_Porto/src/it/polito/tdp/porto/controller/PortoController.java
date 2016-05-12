package it.polito.tdp.porto.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.porto.model.Creator;
import it.polito.tdp.porto.model.PortoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {
	
	private PortoModel model;
	

	public void setModel(PortoModel model){
		this.model = model;	
		cmbAutore1.getItems().addAll(model.popolaTendina());
		cmbAutore2.getItems().addAll(model.popolaTendina());
		model.GenerateGraph();
	}
		

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Creator> cmbAutore1;

    @FXML
    private ComboBox<Creator> cmbAutore2;

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
    	String stampa = "";
    	Creator c = cmbAutore1.getValue();
    	if(c==null){
    		Creator c1 = cmbAutore2.getValue();
    		if(c1==null){
    			txtOutput.setText("Selezionare almeno un autore dalla menù");
    		}
    		else{
    			for(Creator tempC: model.listaCoautori(c1)){
        			stampa += tempC.getFamilyName() + " " + tempC.getGivenName() + "\n";
        		}
    		}
    	}
    	else{
    		for(Creator tempC: model.listaCoautori(c))
    			stampa += tempC.getFamilyName() + " " + tempC.getGivenName() + "\n";
    	}
    	txtOutput.setText(stampa);
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
