package cn.itcast_05_proxy.action;

import org.junit.Test;

import cn.itcast_05_proxy.service.IBoss;
import cn.itcast_05_proxy.service.impl.Boss;

public class SaleAction {
	/**
	 * ��ʹ�ô���ֱ�ӵ��÷���
	 * �����й涨ʲôҵ�񣬾�ֻ�ܵ���ʲôҵ�񣬹涨ʲô����ֵ����ֻ�����ʲô����ֵ
	 */
	@Test
	public void saleByBossSelf() throws Exception {
		IBoss boss = new Boss();
		System.out.println("�ϰ���Ӫ��");
		int money = boss.yifu("xxl");// �ϰ��Լ����·�������Ҫ�ͷ����������û�������¼
		System.out.println("�·��ɽ��ۣ�" + money);
	}
}
