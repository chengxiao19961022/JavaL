package cn.itcast_01_mythread.pool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class TestPool {

	public static void main(String[] args) throws Exception {
		Future<?> submit = null;
		Random random = new Random();
		
		//�����̶������̳߳�
//		ExecutorService exec = Executors.newFixedThreadPool(4);
		
		//���������̳߳�
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(4);
		
		//������¼���̵߳ķ��ؽ��
		ArrayList<Future<?>> results = new ArrayList<Future<?>>();
		
		for (int i = 0; i < 10; i++) {
			//fixedPool�ύ�̣߳�runnable�޷���ֵ��callable�з���ֵ
			/*submit = exec.submit(new TaskRunnable(i));*/
			/*submit = exec.submit(new TaskCallable(i));*/
			
			//����schedulerPool��˵������submit�ύ����ʱ������ͨpoolЧ��һ��
			/*submit = exec.submit(new TaskCallable(i));*/
			//����schedulerPool��˵������schedule�ύ����ʱ����ɰ��ӳ٣������ʱ���������̵߳�����
			submit = exec.schedule(new TaskCallable(i), random.nextInt(10), TimeUnit.SECONDS);
			//�洢�߳�ִ�н��
			results.add(submit);
			
		}
		
		
		//��ӡ���
		for(Future f: results){
			boolean done = f.isDone();
			System.out.println(done?"�����":"δ���");  //�ӽ���Ĵ�ӡ˳����Կ�������ʹδ��ɣ�Ҳ�������ȴ�
			System.out.println("�̷߳���future����� " + f.get());
		}
		
		exec.shutdown();
		
	}
}
