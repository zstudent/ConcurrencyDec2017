package lesson171212;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryUseCondition {
	
	public static void main(String[] args) throws InterruptedException {
		
		Lock lock = new ReentrantLock();
		
		Condition condition = lock.newCondition();
		
		condition.await();
		
		
	}

}
