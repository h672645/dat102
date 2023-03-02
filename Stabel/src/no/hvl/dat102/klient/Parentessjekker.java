package no.hvl.dat102.klient;

import no.hvl.dat102.tabell.*;

public class Parentessjekker<T> implements no.hvl.dat102.adt.Parentessjekker {

	private TabellStabel<Character> parser;

	public Parentessjekker(int kapasitet) {

		parser = new TabellStabel<Character>(kapasitet);
	}

	@Override
	public boolean erVenstreparentes(char p) {
		return (p == '[' || p == '{' || p == '(');
	}

	@Override
	public boolean erHogreparentes(char p) {
		return (p == ']' || p == '}' || p == ')');
	}

	@Override
	public boolean erParentes(char p) {
		return (p == '[' || p == '{' || p == '(' || p == ']' || p == '}' || p == ')');
	}

	@Override
	public boolean erPar(char venstre, char hogre) {

		boolean sjekk = false;

		if (venstre == '(' && hogre == ')') {
			sjekk = true;
		}

		if (venstre == '[' && hogre == ']') {
			sjekk = true;
		}

		if (venstre == '{' && hogre == '}') {
			sjekk = true;
		}

		return sjekk;
	}

	@Override
	public boolean erBalansert(String s) {
		boolean sjekk = false;
		char[] charlist = s.toCharArray();

		for (int i = 0; i < charlist.length; i++) {

			if ((charlist[i]) == '(') {
				parser.push(charlist[i]);
				System.out.print(charlist[i]);
			}
			if((charlist[i]) == ')'){
				if(parser.erTom()) {
					System.out.print("\n Stabelen gikk tom: ");
					return false;
				}
				
				char p = parser.peek();
				if((erPar(p, charlist[i]))) {
					sjekk = true;
				} else {
					System.out.print(charlist[i] + "\nEr ikke par: ");
					return false;
				}
				parser.pop();
				System.out.print(charlist[i]);
			}
			
			if ((charlist[i]) == '[') {
				parser.push(charlist[i]);
				System.out.print(charlist[i]);
			}
			if((charlist[i]) == ']'){
				if(parser.erTom()) {
					System.out.print("\n Stabelen gikk tom: ");
					return false;
				}
				
				char p = parser.peek();
				if((erPar(p, charlist[i]))) {
					sjekk = true;
				} else {
					System.out.print(charlist[i] + "\nEr ikke par: ");
					return false;
				}
				parser.pop();
				System.out.print(charlist[i]);
			}
			
			if ((charlist[i]) == '{') {
				parser.push(charlist[i]);
				System.out.print(charlist[i]);
			}
			if((charlist[i]) == '}'){
				if(parser.erTom()) {
					System.out.print("\n Stabelen gikk tom: ");
					return false;
				}
				
				char p = parser.peek();
				if((erPar(p, charlist[i]))) {
					sjekk = true;
				} else {
					System.out.print(charlist[i] + "\nEr ikke par: ");
					return false;
				}
				parser.pop();
				System.out.print(charlist[i]);
			}
			
		}
		
		if(!parser.erTom()) {
			sjekk = false;
			System.out.println("\nFremdeles flere parenteser i stabel: " + sjekk + "\n");
		}
		
		return sjekk;
	}

}
