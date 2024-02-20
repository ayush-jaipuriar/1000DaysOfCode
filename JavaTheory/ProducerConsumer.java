package JavaTheory;

public class ProducerConsumer {
	// Shared buffer between producer and consumer
	private int buffer = 0;

	// Flag indicating if data is available in the buffer
	private boolean available = false;

	// Synchronized method for producing data
	public synchronized void produce() {
		// Wait while buffer is full (available is true)
		while (available) {
			try {
				wait(); // Release the monitor and wait for notification
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Produce data and update buffer
		buffer++;
		System.out.println("Produced: " + buffer);

		// Set available flag to true and notify waiting threads
		available = true;
		notifyAll(); // Wake up both producer and consumer (for simplicity)
	}

	// Synchronized method for consuming data
	public synchronized void consume() {
		// Wait while buffer is empty (available is false)
		while (!available) {
			try {
				wait(); // Release the monitor and wait for notification
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Consume data and update buffer
		buffer--;
		System.out.println("Consumed: " + buffer);

		// Set available flag to false and notify waiting threads
		available = false;
		notifyAll(); // Wake up both producer and consumer (for simplicity)
	}

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();

		// Create producer and consumer threads
		Thread producerThread = new Thread(() -> pc.produce());
		Thread consumerThread = new Thread(() -> pc.consume());

		// Start the threads
		producerThread.start();
		consumerThread.start();
	}
}
