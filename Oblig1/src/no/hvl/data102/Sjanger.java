package no.hvl.data102;

public enum Sjanger {
	HORROR, ROMANCE, COMEDY, THRILLER, ACTION, UNDEFINED;
	
	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = UNDEFINED;
		for(Sjanger sj : Sjanger.values()) {
			if(sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}
}
