package lesson171204;

import java.util.ArrayList;
import java.util.List;

import lesson171201.Utils;

public class RaceConditionExample {

	volatile static Integer count = 0;

	// synchronized static void make() {
	// synchronized (RaceConditionExample.class) {
	//
	// }
	//
	// }

	static class Counter implements Runnable {

		final private int pause;

		public Counter(int pause) {
			this.pause = pause;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				Utils.pause(pause);
				synchronized (count) {
					count++;
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		// Runnable counter = new Counter(50);

		List<Thread> threads = new ArrayList<Thread>();

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Counter(50));
			t.start();
			threads.add(t);
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println(count);

	}

}
