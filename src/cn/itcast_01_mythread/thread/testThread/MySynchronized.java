package cn.itcast_01_mythread.thread.testThread;

public class MySynchronized {
	public static void main(String[] args) {
		final MySynchronized mySynchronized = new MySynchronized();
		final MySynchronized mySynchronized2 = new MySynchronized();
		new Thread("thread1") {
			public void run() {
				synchronized (mySynchronized) {
				try {
					System.out.println(this.getName()+" start");
//					int i =1/0;   //��������쳣��jvm�Ὣ���ͷ�
					Thread.sleep(5000);
					System.out.println(this.getName()+"����");
					System.out.println(this.getName()+" end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		}.start();
		new Thread("thread2") {
			public void run() {
				synchronized (mySynchronized) {         //����ͬһ����ʱ���߳�1û�ͷ�֮ǰ���߳�2ֻ�ܵȴ�
//					synchronized (mySynchronized2) {    //�������һ���������Կ������仰ͬʱ��ӡ
					System.out.println(this.getName()+" start");
					System.out.println(this.getName()+" end");
					
				}
			}
		}.start();
	}
}
