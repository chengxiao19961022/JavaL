package cn.itcast_05_proxy.service.impl;

import cn.itcast_05_proxy.service.IBoss;


/**
 * ʵ�������·��Ľӿ�
 * �Զ������Լ���ҵ��������
 * @author wilson
 *
 */
public class Boss implements IBoss{
	public int yifu(String size){
		System.err.println("��èСǿ�콢�꣬�ϰ���ͻ������----�·��ͺţ�"+size);
		//����·��ļ�Ǯ�������ݿ��ȡ
		return 50;
	}
	public void kuzi(){
		System.err.println("��èСǿ�콢�꣬�ϰ���ͻ������----����");
	}
}
