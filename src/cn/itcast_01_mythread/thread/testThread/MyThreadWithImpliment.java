package cn.itcast_01_mythread.thread.testThread;


public class MyThreadWithImpliment implements Runnable {
	int x;

	public MyThreadWithImpliment(int x) {
		this.x = x;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("�߳�" + name + "��run���������á���");
		for (int i = 0; i < 10; i++) {
			System.out.println(x);
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new MyThreadWithImpliment(1), "thread-1");
		Thread thread2 = new Thread(new MyThreadWithImpliment(2), "thread-2");
		 thread1.start();
		 thread2.start();
		// ע�����run�͵���start������,ֱ�ӵ���run����������main�߳���
//		thread1.run();
//		thread2.run();
	}
}
