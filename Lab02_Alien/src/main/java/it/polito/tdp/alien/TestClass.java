package it.polito.tdp.alien;

public class TestClass {
	public void run() {
		
		AlienDictionary d = new AlienDictionary();
		
		d.addWord("prv", "prova");
		System.out.println("Nella lingua aliena,prv significa: "+ d.translateWord("prv"));
		
		
	}
	public static void main(String[] args) {
		TestClass c = new TestClass();
		c.run();
	}
	
}
