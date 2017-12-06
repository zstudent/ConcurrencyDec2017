package lesson171205;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> {

	private final Object mutex = new Object();
	private Queue<T> items = new LinkedList<>();

	public void put(T item) {
		synchronized (mutex) {
			items.offer(item);
			mutex.notify();
		}
	}

	public T take() {
		T item = null;
		synchronized (mutex) {
			while (items.isEmpty()) {
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			item = items.poll();
		}
		return item;
	}

}
