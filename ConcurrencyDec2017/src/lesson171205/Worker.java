package lesson171205;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

public class Worker implements Executor {

	private final Object mutex = new Object();
	private Queue<Runnable> tasks = new LinkedList<>();

	public Worker() {
		new Thread(this::processTasks).start();
	}

	public void execute(Runnable task) {
		synchronized (mutex) {
			tasks.offer(task);
			mutex.notify();
		}
	}

	private void processTasks() {
		while (true) {
			Runnable task = null;
			synchronized (mutex) {
				while (tasks.isEmpty()) {
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				task = tasks.poll();
			}
			task.run();
		}
	}

}
