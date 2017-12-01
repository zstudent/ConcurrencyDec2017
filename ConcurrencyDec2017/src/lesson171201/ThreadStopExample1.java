package lesson171201;

public class ThreadStopExample1 {
	
	static class A {
		int x, y;
		
		synchronized public void change() {
			x++;
			Utils.pause(2000);
			y--;
		}
		
		synchronized public void check() {
			if (x + y != 0) {
				throw new IllegalStateException();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		
		A a = new A();
		
		Thread thread = new Thread(() -> {
			while (true) {
				a.change();
			}
		});
		thread.start();
		
		new Thread(() -> {
			while (true) {
				Utils.pause(1000);
				a.check();
			}
		}).start();
		
		Utils.pause(3000);
		System.out.println("kill thread");
		thread.stop();
	}

}
