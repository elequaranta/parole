package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	List<String> elencoParole;
	
	/* tempi di esecuzione ArrayList:
	 * inserimento parola: 90871365502100 ns
	 * cancellazione parola: 90883569112600
	 * reset: 90902764523800
	 * vs
	 * tempi di esecuzione LinkedList:
	 * inserimento parola: 90902764523800
	 * cancellazione parola: 90994958305300
	 * reset: 91019556295700
	 * 
	 * la LinkedList ha tempi di esecuzione più lunghi
	 */
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempi;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	elenco.addParola(txtParola.getText());
    	elencoParole = elenco.getElenco();
    	String ritorno = "";
    	for(String s : elencoParole) {
    		ritorno += s + "\n";
    	}
    	txtResult.setText(ritorno);
    	txtParola.setText("");
    	txtTempi.setText("Tempo di esecuzione [ns] = " + System.nanoTime());
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	elencoParole.clear();
    	txtResult.setText("");
    	txtParola.setText("");
    	txtTempi.setText("Tempo di esecuzione [ns] = " + System.nanoTime());
    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	elencoParole = elenco.cancella(txtParola.getText());
    	String ritorno = "";
    	for(String s : elencoParole) {
    		ritorno += s + "\n";
    	}
    	txtResult.setText(ritorno);
    	txtParola.setText("");
    	txtTempi.setText("Tempo di esecuzione [ns] = " + System.nanoTime());
    }


    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
