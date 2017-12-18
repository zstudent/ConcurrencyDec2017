package lesson171218;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Phaser;

import lesson171201.Utils;

public class PhaserExampleFromDocs {

	public static void main(String[] args) {

		runTasks(Arrays.asList(
		() -> {
			System.out.println("one");
		}, () -> {
			System.out.println("two");
		}, () -> {
			System.out.println("three");
		}));

	}

	static void runTasks(List<Runnable> tasks) {
		final Phaser phaser = new Phaser(1); // "1" to register self
		// create and start threads
		for (final Runnable task : tasks) {
			int phase = phaser.register();
			System.out.println("Phase " + phase);
			new Thread() {
				public void run() {
					System.out.println("start " + Thread.currentThread());
					Utils.pause(15000);
					System.out.println("arrived " + Thread.currentThread());
					phaser.arriveAndAwaitAdvance(); // await all creation
					task.run();
					System.out.println("Next phase: " + phaser.register());
					//...
				}
			}.start();
		}

		// allow threads to start and deregister self
		System.out.println("Main thread phase: " + phaser.arriveAndDeregister());
	}

}
