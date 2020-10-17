package workers;

import java.util.Random;

import principal.Singleton;

public class Consumidor extends Thread {
	
	public void consumir() throws InterruptedException {
		Random r = new Random();
		while (true) {
			Thread.sleep(r.nextInt(1000));
			Singleton singleton = Singleton.getInstance();
			int vetorAux [] = singleton.getVetor();
			boolean rodar = true;
			
			for (int i = 0; i < vetorAux.length; i++) {
				if (singleton.getVetor()[i] == 1) {
					while (rodar) {
						int posicao = r.nextInt(singleton.getVetor().length);
						if (singleton.getVetor()[posicao] == 1) {
							singleton.getSemaforo().acquire();
							singleton.getVetor()[posicao] = 0;
							System.out.print("Consumi - ");
							singleton.showVetor();
							singleton.getSemaforo().release(); 
							rodar = false;
						}
					}
				}
			}
		}
	}
	
	@Override
	public void run () {
		try {
			consumir();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
