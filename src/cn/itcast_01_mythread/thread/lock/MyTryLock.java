package cn.itcast_01_mythread.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �۲�����һ���̻߳��������һ���߳�ȡ������������һֱ�ȴ�
 * @author
 *
 */
public class MyTryLock {

	private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	static Lock lock = new ReentrantLock(); // ע������ط�
	public static void main(String[] args) {
		
		new Thread() {
			public void run() {
				Thread thread = Thread.currentThread();
				boolean tryLock = lock.tryLock();
				System.out.println(thread.getName()+" "+tryLock);
				if (tryLock) {
					try {
						System.out.println(thread.getName() + "�õ�����");
						for (int i = 0; i < 5; i++) {
							arrayList.add(i);
						}
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						System.out.println(thread.getName() + "�ͷ�����");
						lock.unlock();
					}
				}
			};
		}.start();

		new Thread() {
			public void run() {
				Thread thread = Thread.currentThread();
				boolean tryLock = lock.tryLock();
				System.out.println(thread.getName()+" "+tryLock);
				if (tryLock) {
					try {
						System.out.println(thread.getName() + "�õ�����");
						for (int i = 0; i < 5; i++) {
							arrayList.add(i);
						}
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						System.out.println(thread.getName() + "�ͷ�����");
						lock.unlock();
					}
				}

			};
		}.start();
	}


}
