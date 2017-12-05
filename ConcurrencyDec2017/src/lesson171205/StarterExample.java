package lesson171205;

import java.util.Arrays;
import java.util.List;

import lesson171201.Utils;

public class StarterExample {

	static class Runner implements Runnable {

		private Object starter;

		public Runner(Object starter) {
			this.starter = starter;
		}

		@Override
		public void run() {
			synchronized (starter) {
				try {
					starter.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int count = 0;
			while (true) {
				Utils.pause(1000);
				System.out.println(count++);
			}
		}

	}

	public static void main(String[] args) {

		Object mutex = new Object();

		List<Runner> list = Arrays.asList(new Runner(mutex), new Runner(mutex), new Runner(mutex),
				new Runner(mutex));
		
		for (Runner runner : list) {
			new Thread(runner).start();
		}
		
//		System.out.println("Ready...");
//		Utils.pause(1000);
//		System.out.println("Steady...");
//		Utils.pause(1000);
//		System.out.println("Go!");
//		
		
		Utils.pause(1000);
		
		synchronized (mutex) {
			mutex.notify();
			while (true) {}
		}

	}

}
