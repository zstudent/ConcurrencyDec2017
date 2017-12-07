package lesson171207;

import java.util.concurrent.Callable;

public class MyFuture {
	
	Callable callable;
	Object result;
	Object mutex = new Object();

	public MyFuture(Callable callable) {
		this.callable = callable;
	}

	public void setResult(Object result) {
		synchronized (mutex) {
			this.result = result;
			mutex.notify();
		}
		
	}
	
	public Object get() {
		synchronized (mutex) {
			while (result == null) {
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}

}
