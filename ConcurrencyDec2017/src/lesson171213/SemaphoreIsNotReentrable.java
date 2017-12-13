package lesson171213;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreIsNotReentrable {
	
	public static void main(String[] args) {

		Semaphore sem = new Semaphore(1);
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		service.schedule(()->{
			System.out.println(Thread.currentThread());
			sem.release();
		}, 3, TimeUnit.SECONDS);
		
		
		sem.acquireUninterruptibly();
		
		System.out.println("I did it! " + Thread.currentThread());
		
		sem.acquireUninterruptibly();
		
		System.out.println("oops, I did it again! " + Thread.currentThread());
		
	}

}
