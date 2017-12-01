package lesson171130;

public class Example2 {
	
	public static void main(String[] args) {
		
		Thread currentThread = Thread.currentThread();
		
		System.out.println(currentThread);
		ThreadGroup threadGroup = currentThread.getThreadGroup();
		System.out.println(threadGroup);
		
		Thread t = new Thread();
		
		System.out.println(t);
		
		Thread[] threads = new Thread[threadGroup.activeCount()];
		
		threadGroup.enumerate(threads);
		
		for (Thread thread : threads) {
			System.out.println(thread);
		}
		
	}

}
