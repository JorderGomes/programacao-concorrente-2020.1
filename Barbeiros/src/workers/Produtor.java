package workers;

import java.util.Random;

import principal.Singleton;

public class Produtor extends Thread{
	
	public void produzir() throws InterruptedException {
		Random r = new Random();
		while (true) {
			Thread.sleep(r.nextInt(1000));
			Singleton singleton = Singleton.getInstance();
			int vetorAux [] = singleton.getVetor();
			boolean rodar = true;
			
			for (int i = 0; i < vetorAux.length; i++) {
				if (singleton.getVetor()[i] == 0) {
					while (rodar) {
						int posicao = r.nextInt(singleton.getVetor().length);
						if (singleton.getVetor()[posicao] == 0) {
							singleton.getSemaforo().acquire();
							singleton.getVetor()[posicao] = 1;
							System.out.print("Produzi - ");
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
	public void run() {
		try {
			produzir();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
