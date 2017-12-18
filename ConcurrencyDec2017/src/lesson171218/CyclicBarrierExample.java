package lesson171218;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import lesson171201.Utils;

public class CyclicBarrierExample {
	
	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(3, () -> {
			System.err.println("Hurray!");
		});
		
		Random r = new Random();
		
		Runnable task = () -> {
			while (true) {
				System.out.println("start rally " + Thread.currentThread());
				Utils.pause(2000 + r.nextInt(8000));
				try {
					System.out.println("arrived at barrier " + Thread.currentThread());
					cb.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("got it!  let's start again! " + Thread.currentThread());
			}
		};
		
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		
	}

}
