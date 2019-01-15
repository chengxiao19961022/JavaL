package cn.itcast_05_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		final List list = new ArrayList();
		//���Ǳ������
		Object oo = Proxy.newProxyInstance(List.class.getClassLoader(),
				list.getClass().getInterfaces(),new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.err.println("����һ������");
						Object returnValue = method.invoke(list, args);//����
						System.err.println("������ɡ�������");
						if(method.getName().equals("size")){
							return 100;
						}
						return returnValue;
					}
				});
		List list2 = (List) oo;
		list2.add("aaa");
		list2.add("bbb");
		
		System.err.println("size:"+list2.size()+","+list.size());//100,2
		//Ϊʲô����3�Σ�
		//list2.size()���Ҳ����
	}
}
