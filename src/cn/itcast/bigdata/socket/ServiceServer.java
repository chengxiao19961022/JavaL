package cn.itcast.bigdata.socket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceServer {



	public static void main(String[] args) throws Exception {

		// ����һ��serversocket���󶨵�������8899�˿���
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress("localhost", 8899));

		// ���ܿͻ��˵���������;accept��һ��������������һֱ�ȴ������пͻ����������Ӳŷ���
		while (true) {
			Socket socket = server.accept();
			new Thread(new ServiceServerTask(socket)).start();
		}
	}

}
