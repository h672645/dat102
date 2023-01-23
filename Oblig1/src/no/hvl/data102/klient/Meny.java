package no.hvl.data102.klient;
import no.hvl.data102.adt.*;
import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		Film terminator = new Film(1, "thrillerman", "Terminator", 11, Sjanger.THRILLER, "robocorp");
		Film titanic = new Film(2, "romanceman", "Titanic", 22, Sjanger.ROMANCE, "icebergcorp");
		Film avatar = new Film(3, "actionman", "Avatar", 33, Sjanger.ACTION, "bluecorp");
		Film iceage = new Film(4, "comedyman", "IceAge", 44, Sjanger.COMEDY, "iceagecorp");
		Film thething = new Film(5, "horroman", "TheThing", 55, Sjanger.HORROR, "aliencorp");
		Film thething2 = new Film(6, "horroman", "TheThing2", 55, Sjanger.HORROR, "aliencorp");
		filmarkiv.leggTilFilm(terminator);
		filmarkiv.leggTilFilm(titanic);
		filmarkiv.leggTilFilm(avatar);
		filmarkiv.leggTilFilm(iceage);
		filmarkiv.leggTilFilm(thething);
		filmarkiv.leggTilFilm(thething2);
		filmarkiv.antall(Sjanger.ACTION);
		tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "tita");
		tekstgr.skrivUtFilmProdusent(filmarkiv, "ice");
		tekstgr.skrivUtStatistikk(filmarkiv);
		tekstgr.visFilm(terminator);
		tekstgr.visFilm(avatar);
		tekstgr.visFilm(tekstgr.lesFilm());
	}

}