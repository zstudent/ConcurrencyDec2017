package lesson171212;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lesson171201.Utils;

public class CheckMonitorExampleWithLock {

	public static void main(String[] args) {

		System.out.println("start");

		Lock mutex = new ReentrantLock();

		Thread thread = new Thread(() -> {
			Utils.pause(1000);
			try {
				boolean succeed = mutex.tryLock(3, TimeUnit.SECONDS);
				if (!succeed) {
					System.out.println("couldn't lock mutex");
					return;
				}
				try {
					System.out.println("hi there!");
				} finally {
					mutex.unlock();
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		});
		thread.start();

		mutex.lock();
		try {
//			Utils.pause(2000);
//			thread.interrupt();
			while (true) {
			}
		} finally {
			mutex.unlock();
		}

	}

}
