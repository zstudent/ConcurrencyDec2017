package lesson171213;

import java.util.concurrent.Semaphore;

import lesson171201.Utils;

public class SemaphoreExample {
	
	public static void main(String[] args) {
		
		Semaphore sem = new Semaphore(-2);
		
		new Thread(()-> {
			
			sem.acquireUninterruptibly();
			
			System.out.println(sem);
			
//			long count = 0;
//			while (true) {
//				System.out.println(count++);
//			}
			
			
		}).start();
		
		System.out.println("ready...");
		sem.release();
		System.out.println(sem);

		Utils.pause(1000);
		System.out.println("steady...");
		sem.release();
		System.out.println(sem);
		
		Utils.pause(1000);
		System.out.println("go!");
		sem.release();
		System.out.println(sem);
		
	}

}
