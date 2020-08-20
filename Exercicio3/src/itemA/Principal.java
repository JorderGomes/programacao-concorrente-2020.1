package itemA;
//import java.util.Random;

public class Principal {
	
	public static void main(String[] args) {
		Util util = new Util();
		int [] numerosDiferentes = new int[10];
		int [] vetorOrdenado = new int[10]; 
		Worker [] worker = new Worker [10];
		
		for(int i = 1; i <= 10; i++) {
			numerosDiferentes[i - 1] = i;
		}		
		numerosDiferentes =  util.shuffle(numerosDiferentes);
		System.out.println("Vetor desordenado");
		for(int i = 0; i <= 9; i++) {
			System.out.print( numerosDiferentes[i] + " | ");
			
		}
		System.out.println();
		//		
		for(int i = 0; i <= 9; i++) {
			Worker w  = new Worker( numerosDiferentes, i);
			worker[i] = w;
			worker[i].start();
		}
		
		for(int i = 0; i <= 9 ; i++) {
			try {
				worker[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i <= 9 ; i++) {
			int indice = worker[i].getCount();
			int valor = worker[i].getMeuNumero();
			vetorOrdenado[indice] = valor;	
			
//			System.out.println(worker[i].toString());
		}
		
		System.out.println("Vetor ordenado");
		for(int i = 0; i <= 9; i++) {
			System.out.print( vetorOrdenado[i] + " | ");
		}
		
		
	}
	
	
}