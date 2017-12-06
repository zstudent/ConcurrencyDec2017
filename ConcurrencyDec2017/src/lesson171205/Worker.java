package lesson171205;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker implements Executor {

//	private MyBlockingQueue<Runnable> tasks = new MyBlockingQueue<>();
	private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
	final static private Runnable POISON_PILL = () -> {};

	public Worker() {
		new Thread(this::processTasks).start();
	}

	@Override
	public void execute(Runnable task) {
		try {
			tasks.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void processTasks() {
		while (true) {
			Runnable task;
			try {
				task = tasks.take();
				if (task == POISON_PILL) {
					break;
				}
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		try {
			tasks.put(POISON_PILL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
