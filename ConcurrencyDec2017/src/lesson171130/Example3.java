package lesson171130;

import java.lang.Thread.State;

public class Example3 {

	public static void main(String[] args) {

		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("hello, world! " + Thread.currentThread());
			}
		};
		
		State state = t.getState();
		
		System.out.println(state);

		t.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello, world! " + Thread.currentThread());
			}
		});
		
		t2.start();

	}

}
