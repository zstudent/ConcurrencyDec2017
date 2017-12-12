package lesson171212;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	
	static class Counter {
		
		private int count;
		
		private Lock mutex = new ReentrantLock();
		
		public void inc() {
			mutex.lock();      //  synchronized (mutex) {
			try {
				count++;
			} finally {
				mutex.unlock();  //  }
			}
		}
		
		public int get() {
			mutex.lock();      //  synchronized (mutex) {
			try {
				return count;
			} finally {
				mutex.unlock();  //  }
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
	}

}
