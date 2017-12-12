package lesson171212;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lesson171201.Utils;

public class BoundedBufferExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		BoundedBuffer bb = new BoundedBuffer(3);
		
		new Thread(()->{
			while (true) {
				try {
					Object item = bb.take();
					System.out.println(item);
					Utils.pause(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		for (int i = 0; i < 10; i++) {
			bb.put(Integer.toString(i));
			System.out.println("offered " + i);
		}
	}

}

class BoundedBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();
	
	public BoundedBuffer(int capacity) {
		items = new Object[capacity];
	}

	final Object[] items;
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}