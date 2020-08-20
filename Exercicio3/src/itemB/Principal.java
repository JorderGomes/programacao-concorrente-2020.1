package itemB;
//import java.util.Random;

import java.util.Random;

public class Principal {
	public static void main(String[] args) {
		Util util = new Util();
		Random gerador = new Random();
		int [] numerosDiferentes = new int[10];
		int [] vetorOrdenado = new int[10]; 
		Worker [] worker = new Worker [10];
		
		for(int i = 1; i <= 10; i++) {
			numerosDiferentes[i - 1] = i;
		}	
		
		int p1 = gerador.nextInt( 9 );
		int p2 = gerador.nextInt( 9 );
		int p3 = gerador.nextInt( 9 );
		
		numerosDiferentes[p1] = numerosDiferentes[p2];
		numerosDiferentes[p3] = numerosDiferentes[p2];
				
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
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i <= 9 ; i++) {
			int indice = worker[i].getCount();
			int valor = worker[i].getMeuNumero();
			vetorOrdenado[indice] = valor;	

		}
		
		
		for(int i = 0; i <= 9 ; i++) {
			int iNext = i + 1;
			
			if (iNext < 10 &&  vetorOrdenado[iNext] == 0) {
				while(iNext < 10 &&  vetorOrdenado[iNext] == 0) {
					vetorOrdenado[iNext] = vetorOrdenado[i];
					iNext++;
				}
			}
		}
		
		
		System.out.println("Vetor ordenado");
		for(int i = 0; i <= 9; i++) {
			System.out.print( vetorOrdenado[i] + " | ");
		}
		
		
	}
	
	
}