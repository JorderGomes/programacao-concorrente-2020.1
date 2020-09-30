package workers;

import principal.Singleton;

public class ProcessoP extends Thread {
	
	Singleton singleton;
	public ProcessoP() {
	}
	
	public void concorrente() throws InterruptedException {
		while (true) {
			Thread.sleep((long) 1000);
			System.out.println("Processo " + 1 + " na seção não critica" );
			singleton = Singleton.getInstance();
			singleton.setWantp(true);
			if (singleton.isWantq() == false) {
				Thread.sleep((long) 1000);
				System.out.println("Processo " + 1 + " na seção critica" );
				singleton.setWantp(false);
				System.out.println("Processo " + 1 + " saindo da seção critica" );
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
