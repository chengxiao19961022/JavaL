package cn.itcast_02_blockingqueue.main;

import java.util.concurrent.*;

public class TestBlockingQueue {
	
	public static void main(String[] args) {

//		Future<?> submit = null;

//		ExecutorService pool = Executors.newFixedThreadPool(4);

		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
		// BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		// �����õĻ���LinkedBlockingQueueĬ�ϴ�СΪInteger.MAX_VALUE
		// BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		TestBlockingQueueConsumer consumer = new TestBlockingQueueConsumer(queue);
		TestBlockingQueueProducer producer = new TestBlockingQueueProducer(queue);

		for (int i = 0; i < 3; i++) {
			new Thread(producer, "Producer" + (i + 1)).start();
//			pool.execute(producer);
		}
		for (int i = 0; i < 5; i++) {
			new Thread(consumer, "Consumer" + (i + 1)).start();
//			pool.execute(consumer);
		}

//		pool.shutdown();
		
		new Thread(producer, "Producer" + (5)).start();
	
		
		
		
	}
	

}
