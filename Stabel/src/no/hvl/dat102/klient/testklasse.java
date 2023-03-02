package no.hvl.dat102.klient;

public class testklasse {

	public static void main(String[] args) {
		
		Parentessjekker<Character> sjekker1 = new Parentessjekker<Character>(10);
		Parentessjekker<Character> sjekker2 = new Parentessjekker<Character>(10);
		Parentessjekker<Character> sjekker3 = new Parentessjekker<Character>(10);
		Parentessjekker<Character> sjekker4 = new Parentessjekker<Character>(10);
		
		System.out.println("True = lovlig,      False = ulovlig\n");
		
		String test = "{{(([]))}}";
		boolean sjekk = sjekker1.erBalansert(test);
		System.out.println("\n" + sjekk + "\n");
		
		
		test = "(((((]))))";
		sjekk = sjekker2.erBalansert(test);
		System.out.println(sjekk + "\n");
		
		test = "(({}}}";
		sjekk = sjekker3.erBalansert(test);
		System.out.println(sjekk + "\n");
		
		test = "(((((()))";
		sjekk = sjekker4.erBalansert(test);
		
	}
	

}
