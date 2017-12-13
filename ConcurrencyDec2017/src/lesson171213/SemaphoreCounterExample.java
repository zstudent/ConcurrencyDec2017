package lesson171213;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreCounterExample {

	static class Counter {

		private int count;

		Semaphore sem = new Semaphore(1);

		public void inc() {
			sem.acquireUninterruptibly(); // synchronized (mutex) {
			try {
				count++;
			} finally {
				sem.release(); // }
			}
		}

		public int get() {
			sem.acquireUninterruptibly(); // synchronized (mutex) {
			try {
				return count;
			} finally {
				sem.release(); // }
			}
		}

	}

	public static void main(String[] args) {

	}

}
