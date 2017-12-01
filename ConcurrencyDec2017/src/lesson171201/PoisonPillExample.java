package lesson171201;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PoisonPillExample {
	
	public static final String POISON_PILL = "";
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		BlockingQueue<String> tasks = new LinkedBlockingQueue<>();
		
		tasks.add("one");
		tasks.add("two");
		tasks.add("three");
		tasks.add("four");
		
		System.out.println(tasks.size());
		
		new Thread(() -> {
			while (true) {
				try {
					String task = tasks.take();
					if (task == POISON_PILL) {
						break;
					}
					System.out.println(task);
					Utils.pause(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		tasks.add("five");
		tasks.add("six");
		
		tasks.add(POISON_PILL);

		tasks.add("seven");
		tasks.add("eight");
		
		System.out.println(tasks.size());
	}

}
