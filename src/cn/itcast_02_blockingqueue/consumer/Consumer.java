package cn.itcast_02_blockingqueue.consumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{  
    BlockingQueue<String> queue; 
    public Consumer(BlockingQueue<String> queue){  
        this.queue = queue;  
    }        
    @Override  
    public void run() {  
        try {  
        	String consumer = Thread.currentThread().getName();
        	System.out.println(consumer);  
            String temp = queue.take();//�������Ϊ�գ���������ǰ�߳�  
            System.out.println(consumer+"get a product:"+temp);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  

