package principal;

import workers.Consumidor;
import workers.Produtor;

public class Principal {
	public static void main(String[] args) {
		//Singleton singleton = Singleton.getInstance();
		Produtor p  = new Produtor() ;
		Consumidor c = new Consumidor();
		
		p.start();
		c.start();
	}
}
