package workers;

import principal.Singleton;

public class ProcessoQ extends Thread {
	
	Singleton singleton;
	public ProcessoQ() {
	}
	
	public void concorrente() throws InterruptedException {
		while (true) {
			Thread.sleep((long) 1000);
			System.out.println("Processo " + 2 + " na seção não critica" );
			singleton = Singleton.getInstance();
			if (singleton.isWantp() == false) {
				Thread.sleep((long) 1000);
				singleton.setWantq(true);
				System.out.println("Processo " + 2 + " na seção critica" );
				singleton.setWantq(false);
				System.out.println("Processo " + 2 + " saindo da seção critica" );
			}
		}
	}
	
	@Override
	public void run() {
		try {
			this.concorrente();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
