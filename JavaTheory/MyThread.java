package JavaTheory;

class MyThread extends Thread{
	
	public void run() {
		for (int i=0; i<10000; i++) {
			System.out.println("Thread id : " + Thread.currentThread().getId() + " count = " + i);
            try {
                // Introduce a short delay
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}

}

