package cn.itcast_05_proxy.action;

import org.junit.Test;

import cn.itcast_05_proxy.proxyclass.ProxyBoss;
import cn.itcast_05_proxy.service.IBoss;
import cn.itcast_05_proxy.service.impl.Boss;

/**
 * ʲô�Ƕ�̬���� �򵥵�дһ��ģ��ӿڣ�ʣ�µĸ��Ի��������ø���̬��������ɣ�
 */
public class ProxySaleAction {
	
	/**
	 *ʹ�ô�������������У�ֻ������Boss��yifu����
	 *���ƻ�ҵ�񣬿��Ըı�ԭ�ӿڵĲ���������ֵ��
	 */
	@Test
	public void saleByProxy() throws Exception {
		IBoss boss = ProxyBoss.getProxy(10,IBoss.class,Boss.class);// ������ķ���ʵ�����ɽӿ�
		//IBoss boss = new Boss();// ������ķ���ʵ�����ɽӿ�
		System.out.println("����Ӫ��");
		int money = boss.yifu("xxl");// ���ýӿڵķ�����ʵ���ϵ��÷�ʽû�б�
		System.out.println("�·��ɽ��ۣ�" + money);
	}
}
