package cn.itcast_01_mythread.thread.testThread;

import java.util.Random;

public class MyThreadWithExtends extends Thread {
	String flag;
	
	public MyThreadWithExtends(String flag){
		this.flag = flag;
	}
	
	

	@Override
	public void run() {
		String tname = Thread.currentThread().getName();
		System.out.println(tname+"�̵߳�run���������á���");
		Random random = new Random();
		for(int i=0;i<20;i++){
			try {
				Thread.sleep(random.nextInt(10)*100);
				System.out.println(tname+ "...."+ flag);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new MyThreadWithExtends("a");
		Thread thread2 = new MyThreadWithExtends("b");
		thread1.start();
		thread2.start();
		/**
		 * ����ǵ���thread��run��������ֻ��һ����ͨ�ķ������ã����Ὺ���µ��߳�
		 */
//		thread1.run();
//		thread2.run();
	}
}
