package cn.itcast_01_mythread.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ʹ�ö�д��������ʵ�ֶ�д�����������������������У�д�������������߳�
 * 
 * �����һ���߳��Ѿ�ռ���˶��������ʱ�����߳����Ҫ����д����������д�����̻߳�һֱ�ȴ��ͷŶ�����
 * �����һ���߳��Ѿ�ռ����д�������ʱ�����߳��������д�����߶�������������̻߳�һֱ�ȴ��ͷ�д����
 * @author
 *
 */
public class MyReentrantReadWriteLock {
	 private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
     
	    public static void main(String[] args)  {
	        final MyReentrantReadWriteLock test = new MyReentrantReadWriteLock();
	         
	        new Thread(){
	            public void run() {
	                test.get(Thread.currentThread());
	                test.write(Thread.currentThread());
	            };
	        }.start();
	         
	        new Thread(){
	            public void run() {
	                test.get(Thread.currentThread());
	                test.write(Thread.currentThread());
	            };
	        }.start();
	         
	    }  
	    
	    /**
	     * ������,�ö���������
	     * @param thread
	     */
	    public void get(Thread thread) {
	        rwl.readLock().lock();
	        try {
	            long start = System.currentTimeMillis();
	             
	            while(System.currentTimeMillis() - start <= 1) {
	                System.out.println(thread.getName()+"���ڽ��ж�����");
	            }
	            System.out.println(thread.getName()+"���������");
	        } finally {
	            rwl.readLock().unlock();
	        }
	    }

	    /**
	     * д��������д��������
	     * @param thread
	     */
	    public void write(Thread thread) {
	        rwl.writeLock().lock();;
	        try {
	            long start = System.currentTimeMillis();
	             
	            while(System.currentTimeMillis() - start <= 1) {
	                System.out.println(thread.getName()+"���ڽ���д����");
	            }
	            System.out.println(thread.getName()+"д�������");
	        } finally {
	            rwl.writeLock().unlock();
	        }
	    }
}
