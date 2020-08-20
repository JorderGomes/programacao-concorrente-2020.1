import java.util.Random;

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
			System.out.println( numerosDiferentes[i] );
		}
//		
		for(int i = 0; i <= 9; i++) {
			Worker w  = new Worker( numerosDiferentes, i, vetorOrdenado );
			worker[i] = w;
			worker[i].start();
		}
		
		
		
		System.out.println("Vetor ordenado");
		for(int i = 0; i <= 9; i++) {
			System.out.println( vetorOrdenado[i] );
		}
		
		
	}
	
	
}