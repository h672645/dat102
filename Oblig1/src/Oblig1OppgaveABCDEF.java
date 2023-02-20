
public class Oblig1OppgaveABCDEF {

	//Svar på oppgavene på bildefiler i samme mappe/pakke.
	
	public static void main (String[] args) {
		
		
		long tid = tid(10000000);
		System.out.println(tid + "\n");
		tid = tid(100000000);
		System.out.println(tid + "\n");
		tid = tid(1000000000);
		System.out.println(tid + "\n");
	}
	
	public static long tid (long n) {
		long k = 0;
		for(long i = 1; i <= n; i++) {
			k = k + 5;
		}
		return k;
	}
	
	
	
	

	
	
}
