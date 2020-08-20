public class Worker extends Thread {
	
	private int meuNumero, count;
	private int [] numerosDiferentes = new int[10];
	private int [] vetorOrdenado = new int[10];
	private int i;
	public Worker(int[] numerosDiferentes, int i, int[] vetorOrdenado) {
		this.numerosDiferentes = numerosDiferentes;
		this.vetorOrdenado = vetorOrdenado;
		this.i = i;
	}

	public void ordenar() {
		meuNumero = numerosDiferentes[i];
		
		count = countLowerNumbers(numerosDiferentes, meuNumero);
		
		vetorOrdenado[count] = meuNumero;

	}
	
	private int countLowerNumbers(int [] numerosDiferentes, int meuNumero) {
		int contador = 0;
		for (int numero : numerosDiferentes) {
			if (numero < meuNumero) {
				contador++;
			}
		}
		return contador;
	}
	
	
	public void run(  ) {
		this.ordenar();
	}
	
}
