package itemA;
import java.util.Random;

public class Util {
	
	public int[] shuffle(int[] vetor) {
		int qtd = 100;
		 Random gerador = new Random();

		while (qtd != 0) {
			int posicao1 = gerador.nextInt( 10 );
			int posicao2 = gerador.nextInt( 10 );
			int aux;
			aux = vetor[posicao1];
			vetor[posicao1] = vetor[posicao2];
			vetor[posicao2] = aux;
			
			qtd--;
		}
		return vetor;
	}
	
}
