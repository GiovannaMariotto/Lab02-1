package it.polito.tdp.alien;

public class Word {

	protected String alianWord;  //punto 1
	private String translation;
	

	public void setTranslation(String translation) {
		this.translation = translation;
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
		Word other = (Word) obj;
		if (alianWord == null) {
			if (other.alianWord != null)
				return false;
		} else if (!alianWord.equals(other.alianWord))
			return false;
		return true;
	}

	

	public Word(String alianWord, String translation) {
		this.alianWord = alianWord;
		this.translation = translation;
	}
	
	public Word(String alianWord) {
		this.alianWord = alianWord;
		
	}
	
	public String getTranslation() {
		return this.translation;
	}
	

}
