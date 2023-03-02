package no.hvl.dat102.mengde.kjedet;

public class Datakontrakt {

	private int antallMedlemmer;
	private Medlem[] tab;
	private int parNummer = 0;

	public Datakontrakt(int antall) {
		antallMedlemmer = 0;
		tab = new Medlem[antall];
	}

	public void leggTil(Medlem medlem) {
		tab[antallMedlemmer] = medlem;
		antallMedlemmer++;
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int indeks = -1;

		for (int i = 0; i < antallMedlemmer; i++) {
			if (tab[i].getNavn().equals(medlemsnavn)) {
				return i;
			}
		}
		return indeks;
	}

	public int finnPartnerFor(String medlemsnavn) {

		int medlemsIndeks = this.finnMedlemsIndeks(medlemsnavn);

		for (int i = 0; i < antallMedlemmer; i++) {
			if (tab[i].passerTil(tab[medlemsIndeks]) && (tab[i].getKoblet() == -1)) {
				if (tab[i].getNavn() != tab[medlemsIndeks].getNavn()) {
					tab[i].setKoblet(parNummer);
					tab[medlemsIndeks].setKoblet(parNummer);
					parNummer++;
					return i;
				}
			}
		}
		return -1;
	}

	public boolean tilbakestillStatusIndeks(String medlemsnavn) {

		int index = finnMedlemsIndeks(medlemsnavn);

		for (int i = 0; i < antallMedlemmer; i++) {
			if (tab[i].passerTil(tab[index]) && (tab[i].getKoblet() == tab[index].getKoblet())) {

				if (i != index) {
					tab[i].removeKoblet();
					tab[index].removeKoblet();
					return true;
				}
			}
		}

		return false;
	}

	public String parliste() {

		if (parNummer == -1) {
			return null;
		}

		String utTxt = "---------\n Parlister: \n";

		for (int i = 0; i < parNummer; i++) {

			utTxt += "#" + i + "\n";

			for (int j = 0; j < antallMedlemmer; j++) {

				if (tab[j].getKoblet() == i) {
					utTxt += tab[j].toString();
				}

			}

		}

		return utTxt + "\n---------\n";
	}

}
