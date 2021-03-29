package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {

	protected String alianWord;  //punto 1
	private List<String> translations;
	

	public void setTranslation(String translation) {
		if(!translations.contains(translation)) {
			translations.add(translation);
		}
	}

	public String getAlianWord() {
		return alianWord;
	}

	public void setAlianWord(String alianWord) {
		this.alianWord = alianWord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alianWord == null) ? 0 : alianWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alianWord == null) {
			if (other.alianWord != null)
				return false;
		} else if (!alianWord.equals(other.alianWord))
			return false;
		return true;
	}

	

	public WordEnhanced(String alianWord, String translation) {
		this.alianWord = alianWord;
		this.translations = new ArrayList<String>();
		this.translations.add(translation);
	}
	
	
	
	public WordEnhanced(String alianWord) {
		this.alianWord = alianWord;
		this.translations = new ArrayList<String>();
		
		
	}
	
	public String getTranslation() {
		String s ="";
		for(String t :translations) {
			s+= t +"\n";
			
			
		}
		
		return s;
	}
	

}
