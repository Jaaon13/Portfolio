package event;

public class event {
	
	private boolean makeThread;
	private boolean killThread;
	private boolean reset;
	
	public event(boolean mT, boolean kT, boolean r) {
		
		this.makeThread = mT;
		this.killThread = kT;
		this.reset = r;
		
	}

	public boolean isMakeThread() {
		return makeThread;
	}

	public boolean isKillThread() {
		return killThread;
	}

	public boolean isReset() {
		return reset;
	}
	
}
