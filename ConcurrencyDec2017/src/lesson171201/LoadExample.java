package lesson171201;

/*
 * Elapsed: 12784  count = 8668241197  4 cpus
 * Elapsed: 10846  count = 7593623510  1 cpu
 */

public class LoadExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				System.out.println(i);
			}
		});
		
		Thread t2 = new Thread(() -> {
			long count = 0;
			while (!Thread.interrupted()) {
				count++;
			}
			System.out.println("count = " + count);
		});
		
		long start = System.currentTimeMillis();
		
		t1.start();
		
		t2.start();
		
		t1.join();
		
		t2.interrupt();
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop - start));
		
		
	}

}
