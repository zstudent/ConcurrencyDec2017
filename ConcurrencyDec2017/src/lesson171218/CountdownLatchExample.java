package lesson171218;

import java.util.concurrent.CountDownLatch;

class CountdownLatchExample { // ...
	   private static final int N = 8;

	void main() throws InterruptedException {
	     CountDownLatch startSignal = new CountDownLatch(1);
	     CountDownLatch doneSignal = new CountDownLatch(N);

	     for (int i = 0; i < N; ++i) // create and start threads
	       new Thread(new Worker(startSignal, doneSignal)).start();

	     doSomethingElse();            // don't let run yet
	     startSignal.countDown();      // let all threads proceed
	     doSomethingElse();
	     doneSignal.await();           // wait for all to finish
	   }

	private void doSomethingElse() {
		// TODO Auto-generated method stub
		
	}
	 }

	 class Worker implements Runnable {
	   private final CountDownLatch startSignal;
	   private final CountDownLatch doneSignal;
	   Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
	     this.startSignal = startSignal;
	     this.doneSignal = doneSignal;
	   }
	   public void run() {
	     try {
	       startSignal.await();
	       doWork();
	       doneSignal.countDown();
	     } catch (InterruptedException ex) {} // return;
	   }

	   void doWork() { 
		   //
	   }
	 }