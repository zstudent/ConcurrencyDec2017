package lesson171212;

import lesson171201.Utils;

public class DeadLockSolution1 {
	
	static class Philisopher {
		
		void use(Object right, Object left) {
			synchronized (right) {
				System.out.println(this + " got " + right);
				Utils.pause(300);
				synchronized (left) {
					System.out.println(this + " got " + left);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Object a = new Object();
		
		Object b = new Object();
		
		Philisopher first = new Philisopher();
		Philisopher second = new Philisopher();
		
		new Thread(() -> {
			first.use(a, b);
		}).start();
		
		new Thread(() -> {
			second.use(b, a);
		}).start();
		
		
	}

}
