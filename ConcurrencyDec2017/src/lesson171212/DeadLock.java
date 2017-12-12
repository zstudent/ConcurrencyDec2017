package lesson171212;

import lesson171201.Utils;

public class DeadLock {
	
	static class First {
		
		void use(Object one, Object two) {
			synchronized (one) {
				System.out.println(this + " got " + one);
				Utils.pause(300);
				synchronized (two) {
					System.out.println(this + " got " + two);
				}
			}
		}
	}
	
	
	static class Second {

		void use(Object one, Object two) {
			synchronized (two) {
				System.out.println(this + " got " + two);
				Utils.pause(300);
				synchronized (one) {
					System.out.println(this + " got " + one);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Object a = new Object();
		
		Object b = new Object();
		
		First first = new First();
		
		Second second = new Second();
		
		new Thread(() -> {
			first.use(a, b);
		}).start();
		
		new Thread(() -> {
			second.use(a, b);
		}).start();
		
		
	}

}
