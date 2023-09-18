package JavaTheory;

public class CreatingThreads {

	public static void main(String[] args) {
		WorkerThread workerThread = new WorkerThread();
		workerThread.start();
		
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		
		
	}

}

// Creating a Thread by implementing the Runnable Interface
class MyRunnable implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Executing Job 1");
		}
	}
}


// Creating a Thread by extending the Thread Class
class WorkerThread extends Thread {
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("Excuting Job 2");
		}
	}
}
