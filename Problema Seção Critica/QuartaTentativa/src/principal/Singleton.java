package principal;

public class Singleton {
	private boolean wantp = false;
	private boolean wantq = false;
	
	private static Singleton uniqueInstance;

	private Singleton() {
	}

	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Singleton();

		return uniqueInstance;
	}

	public boolean isWantp() {
		return wantp;
	}

	public void setWantp(boolean wantp) {
		this.wantp = wantp;
	}

	public boolean isWantq() {
		return wantq;
	}

	public void setWantq(boolean wantq) {
		this.wantq = wantq;
	}

	
	
}
