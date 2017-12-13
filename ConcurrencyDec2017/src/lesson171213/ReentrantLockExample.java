package lesson171213;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lesson171201.Utils;

public class ReentrantLockExample {
	
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		
		lock.lock();
		
		lock.lock();
		
		lock.unlock();
		
		new Thread(() -> {
			Lock internalLock = lock;
			System.out.println("first");
			internalLock.lock();
//			System.out.println((succeed? "locked" : "failed to lock by ") + Thread.currentThread());
			System.out.println("got it, finally!");
		}).start();
		
		Utils.pause(500);
		
		System.out.println("-- second unlock");
		lock.unlock();
		System.out.println("-- second unlock done");
		
		Utils.pause(500);
		
		new Thread(() -> {
			System.out.println("second");
//			boolean succeed = lock.tryLock();
			lock.unlock();
//			System.out.println((succeed? "locked" : "failed to lock by ") + Thread.currentThread());
		}).start();
		
	}

}
