package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary ad = new AlienDictionary();
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField parolatxt;

    @FXML
    private Button btntraslate;

    @FXML
    private TextArea risultatotxt;

    @FXML
    private Button btnreset;

    @FXML
    void doReset(ActionEvent event) {
    	ad.doReset();
    	parolatxt.clear();
    	risultatotxt.clear();
    }

    @FXML
    void doTraslate(ActionEvent event) {
    	risultatotxt.clear();
    	String riga = parolatxt.getText().toLowerCase(); 
    	StringTokenizer st = new StringTokenizer(riga," ");
    	
    	if(riga==null || riga.length()==0) { //non c'è niente in riga
    		risultatotxt.setText("Inserire una parola o due");
    		return;
    	}
    	
    	
    	if(!st.hasMoreTokens()) {
    		risultatotxt.setText("Inserire una parola o due");
    		return;
    	}
    	
    	String alienWord = st.nextToken();
    	
    	if(st.hasMoreTokens()) {
    		String translation = st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			this.risultatotxt.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		ad.addWord(alienWord, translation);
    		risultatotxt.setText("La parola "+alienWord+" è stata aggiunta");
    	} else {
    		if(!alienWord.matches("[a-zA-Z]*") ) {
    			this.risultatotxt.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		String translation = ad.translateWord(alienWord);
    		
    		if(translation!=null) {
    			this.risultatotxt.setText(translation);
    		} else {
    			this.risultatotxt.setText("La parola non è presente nel dizionario");
    		}
    	}
    	
    }

    @FXML
    void initialize() {
        assert parolatxt != null : "fx:id=\"parolatxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btntraslate != null : "fx:id=\"btntraslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert risultatotxt != null : "fx:id=\"risultatotxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnreset != null : "fx:id=\"btnreset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
