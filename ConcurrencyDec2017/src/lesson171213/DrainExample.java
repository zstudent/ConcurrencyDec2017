package lesson171213;

import java.util.concurrent.Semaphore;

public class DrainExample {
	
	public static void main(String[] args) {
		
		Semaphore sem = new Semaphore(10);
		
		int available = sem.availablePermits();
		
		// ....
		// ....
		// ....
		
		sem.acquireUninterruptibly(available);
		
		int permits = sem.drainPermits();
		
	}

}
