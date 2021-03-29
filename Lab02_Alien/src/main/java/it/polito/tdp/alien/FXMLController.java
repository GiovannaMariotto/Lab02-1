package it.polito.tdp.alien;

import java.awt.TextArea;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXMLController {

	AlienDictionary dictionary =new AlienDictionary();
	
    @FXML
    private TextField parolatxt;
	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextArea risultatotxt;

    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;

    @FXML
    void doTranslate(ActionEvent event) {
    
    	String temp= this.parolatxt.getText().toLowerCase();
    	if(temp==null || temp.length()==0 ) {
    		System.out.print("Inserisce una o due parole");
    		return;
    	}
    		
    	StringTokenizer st = new StringTokenizer(temp," ");
    	if(!st.hasMoreTokens()) {
    		System.out.print("Inserisce una o due parole");
    		return;
    	}
    	
    	String alienWord = st.nextToken();
    	if(st.hasMoreElements()) {
    		String translation = st.nextToken();
    		if(alienWord.matches("[a-zA-Z]*") || translation.matches("[a-zA-Z]*")) {
    			this.risultatotxt.setText("Inserire solo caratteri alfabetici");
    			return;
    			
    		}
    		dictionary.addWord(alienWord, translation);
    		this.risultatotxt.setText("La parola \""+ alienWord +"è stata aggiunta con traduzione\""+ translation+"\n");
    		
    	}
    	else {
    		if(!alienWord.matches("[a-zA-Z]*")) {
    			this.risultatotxt.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		String translation = dictionary.translateWord(alienWord);
    		if(translation!=null) {
    			this.risultatotxt.setText(translation);
    		}else {
    			this.risultatotxt.setText("La parola non è presente nello dizionario");
    			
    		}
    	}
    		
    		
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	dictionary.doReset();
    	risultatotxt.setText("");
    	this.parolatxt.setText("");
    	
    }
    
    
    @FXML
    void initialize() {

    }
}