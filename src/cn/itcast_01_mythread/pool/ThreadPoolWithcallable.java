package cn.itcast_01_mythread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * callable ��runnable������
 * runnable��run�����������κη��ؽ�����������߳��޷���������̵߳ķ���ֵ
 * 
 * callable��call�������Է��ؽ�����������߳��ڻ�ȡʱ�Ǳ���������Ҫ�ȴ������̷߳��ز����õ����
 * @author
 *
 */
public class ThreadPoolWithcallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(4); 
		
		for(int i = 0; i < 10; i++){
			Future<String> submit = pool.submit(new Callable<String>(){
				@Override
				public String call() throws Exception {
					//System.out.println("a");
					Thread.sleep(5000);
					return "b--"+Thread.currentThread().getName();
				}			   
			   });
			//��Future��get�������������ǻᱻ�����ģ�һֱҪ�ȵ��߳����񷵻ؽ��
			System.out.println(submit.get());
		} 
			pool.shutdown();

	}

}
