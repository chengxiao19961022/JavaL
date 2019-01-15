package cn.itcast.bigdata.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceServerTask implements Runnable{
	Socket socket ;
	InputStream in=null;
	OutputStream out = null;
	
	public ServiceServerTask(Socket socket) {
		this.socket = socket;
	}

	//ҵ���߼������ͻ��˽������ݽ���
	@Override
	public void run() {
		try {
			//��socket�����л�ȡ����client֮�������ͨ�����������
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//������ͨ���������ж�ȡ�ͻ��˷��͹���������
			//ע�⣺socketinputstream�Ķ����ݵķ������������� 
			String param = br.readLine();
			
			
			/**
			 * ��ҵ��
			 * ������ҵ������߼�д�ɸ���ͨ�õģ����Ը��ݿͻ��˷������ĵ������������÷����������øò�����������
			 * 
			 * �����䡷
			 * 
			 */
			
			GetDataServiceImpl getDataServiceImpl = new GetDataServiceImpl();
			String result = getDataServiceImpl.getData(param);
			
			
			//�����ý��д��sokect��������У��Է��͸��ͻ���
			PrintWriter pw = new PrintWriter(out);
			pw.println(result);
			pw.flush();
			
			
			
		} catch (IOException e) {
			 
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
