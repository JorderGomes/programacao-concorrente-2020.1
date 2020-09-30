package principal;

import workers.ProcessoP;
import workers.ProcessoQ;

public class Principal {
	
	public static void main(String[] args) {
		Singleton turn = Singleton.getInstance();
		
		ProcessoP p = new ProcessoP();
		ProcessoQ q = new ProcessoQ();
		
		p.start();
		q.start();
		
	}
}
