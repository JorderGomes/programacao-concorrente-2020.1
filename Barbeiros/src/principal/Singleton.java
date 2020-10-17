package principal;

import java.util.concurrent.Semaphore;

public class Singleton {
	private static Singleton singleton;
	
	private Semaphore semaforo;
	int vetor [] = new int[10];
	
	
	private Singleton() {
		this.semaforo = new Semaphore(1);
	}
	
	public static Singleton getInstance() {
		if (singleton == null)
			singleton = new Singleton();

		return singleton;
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	public int[] getVetor() {
		return vetor;
	}

	public void setVetor(int[] vetor) {
		this.vetor = vetor;
	}
	
	public void showVetor() {
		System.out.print("[ ");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("]");
	}
	
}
