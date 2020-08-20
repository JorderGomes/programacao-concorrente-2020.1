package itemB;
public class Worker extends Thread {
	
	private int meuNumero, count;
	private int [] numerosDiferentes = new int[10];
	private int i;
	
	public Worker(int[] numerosDiferentes, int i) {
		this.numerosDiferentes = numerosDiferentes;
		this.i = i;
	}	
	public int getMeuNumero() {
		return meuNumero;
	}

	public void setMeuNumero(int meuNumero) {
		this.meuNumero = meuNumero;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

	
	public void ordenar() {
		meuNumero = numerosDiferentes[i];
		count = countLowerNumbers(numerosDiferentes, meuNumero);
		
		
//		vetorOrdenado[count] = meuNumero;

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
	
	
	
	@Override
	public String toString() {
		return "Worker [meuNumero=" + meuNumero + ", count=" + count + "]";
	}

	public void run(  ) {
		this.ordenar();
	}
	
}
