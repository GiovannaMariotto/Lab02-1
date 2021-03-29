package it.polito.tdp.alien;

import java.awt.List;
import java.util.*;
import java.awt.Point;
import java.util.ArrayList;

public class AlienDictionary {

	private ArrayList<WordEnhanced> dictionary ;
	
	public AlienDictionary() {
		dictionary = new ArrayList<WordEnhanced>();
		
	}
	
	public void doReset() {
		dictionary.clear();
	}
	
	
	public void addWord(String alienWord, String traslation) { //punto 3
		WordEnhanced w = new WordEnhanced(alienWord);
			if(dictionary.contains(w)) { //if this word already exists, update the translation
				dictionary.get(dictionary.indexOf(w)).setTranslation(traslation); ; 
				return;
			}
			w.setTranslation(traslation);
		dictionary.add(w);
		
		
	}

	
	public String translateWord(String alienWord) { //punto 3
		WordEnhanced w = new WordEnhanced(alienWord);
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null; //if not found: null
		
	}
	
	
	
}
