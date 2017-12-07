package lesson171207;

import lesson171201.Utils;

public class ExceptionHandlingExample {

	public static void main(String[] args) {

		new Thread(() -> {
			while (true) {
				Utils.pause(1000);
				System.out.println("hello");
			}
		}).start();
		
		Utils.pause(1000);
		
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + " raised " + e);
			}
		});

		throw new RuntimeException();
	}

}
