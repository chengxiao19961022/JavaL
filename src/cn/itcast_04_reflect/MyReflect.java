package cn.itcast_04_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyReflect {
	public String className = null;
	@SuppressWarnings("rawtypes")
	public Class personClass = null;
	/**
	 * ����Person��
	 * @throws Exception 
	 */
	@Before
	public void init() throws Exception {
		className = "cn.itcast_04_reflect.Person";
		personClass = Class.forName(className);
	}
	/**
	 *��ȡĳ��class�ļ�����
	 */
	@Test
	public void getClassName() throws Exception {
		System.out.println(personClass);
	}
	/**
	 ��ȡĳ��class�ļ��������һ�ַ�ʽ
	 */
	@Test
	public void getClassName2() throws Exception {
		System.out.println(Person.class);
	}
	/**
	 *����һ��class�ļ���ʾ��ʵ�����󣬵ײ����ÿղ����Ĺ��췽��
	 */
	@Test
	public void getNewInstance() throws Exception {
		System.out.println(personClass.newInstance());
	}
	/**
	 *��ȡ��˽�еĹ��캯��
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getPublicConstructor() throws Exception {
		Constructor  constructor  = personClass.getConstructor(Long.class,String.class);
		Person person = (Person)constructor.newInstance(100L,"zhangsan");
		System.out.println(person.getId());
		System.out.println(person.getName());
	}
	/**
	 *���˽�еĹ��캯��
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getPrivateConstructor() throws Exception {
		Constructor con = personClass.getDeclaredConstructor(String.class);
		con.setAccessible(true);//ǿ��ȡ��Java��Ȩ�޼��
		Person person2 = (Person)con.newInstance("zhangsan");
		System.out.println("**"+person2.getName());
	}
	/**
	 *���ʷ�˽�еĳ�Ա����
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getNotPrivateField() throws Exception {
		Constructor  constructor  = personClass.getConstructor(Long.class,String.class);
		Person obj = (Person) constructor.newInstance(100L,"zhangsan");
		
		Field field = personClass.getField("name");
		field.set(obj, "lisi");
		System.out.println(field.get(obj));
	}
	/**
	 *����˽�еĳ�Ա����
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getPrivateField() throws Exception {
		Constructor  constructor  = personClass.getConstructor(Long.class);
		Object obj = constructor.newInstance(100L);
		
		Field field2 = personClass.getDeclaredField("id");
		field2.setAccessible(true);//ǿ��ȡ��Java��Ȩ�޼��
		field2.set(obj,10000L);
		System.out.println(field2.get(obj));
	}
	/**
	 *��ȡ��˽�еĳ�Ա����
	 */
	@SuppressWarnings({ "unchecked" })
	@Test
	public void getNotPrivateMethod() throws Exception {
		System.out.println(personClass.getMethod("toString"));
		
		Object obj = personClass.newInstance();//��ȡ�ղεĹ��캯��
		Method toStringMethod = personClass.getMethod("toString");
		Object object = toStringMethod.invoke(obj);
		System.out.println(object);
	}
	/**
	 *��ȡ˽�еĳ�Ա����
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getPrivateMethod() throws Exception {
		Object obj = personClass.newInstance();//��ȡ�ղεĹ��캯��
		Method method = personClass.getDeclaredMethod("getSomeThing");
		method.setAccessible(true);
		Object value = method.invoke(obj);
		System.out.println(value);

	}
	/**
	 *
	 */
	@Test
	public void otherMethod() throws Exception {
		//��ǰ�������class�ļ����Ǹ������������
		System.out.println(personClass.getClassLoader());
		//��ȡĳ����ʵ�ֵ����нӿ�
		Class[] interfaces = personClass.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1);
		}
		//���䵱ǰ������ֱ�Ӹ���
		System.out.println(personClass.getGenericSuperclass());
		/**
		 * getResourceAsStream����������Ի�ȡ��һ��������������������������name����ʾ���Ǹ��ļ��ϡ�
		 */
		//path ���ԡ�/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ���ԡ�/'��ͷ���Ǵ�ClassPath���»�ȡ����ֻ��ͨ��path����һ������·�������ջ�����ClassLoader��ȡ��Դ��
		System.out.println(personClass.getResourceAsStream("/log4j.properties"));
		System.out.println(personClass.getResourceAsStream("log4j.properties"));
		
		//�жϵ�ǰ��Class�����ʾ�Ƿ�������
		System.out.println(personClass.isArray());
		System.out.println(new String[3].getClass().isArray());
		
		//�жϵ�ǰ��Class�����ʾ�Ƿ���ö����
		System.out.println(personClass.isEnum());
		System.out.println(Class.forName("cn.itcast_04_reflect.City").isEnum());
		
		//�жϵ�ǰ��Class�����ʾ�Ƿ��ǽӿ�
		System.out.println(personClass.isInterface());
		System.out.println(Class.forName("cn.itcast_04_reflect.TestInterface").isInterface());
		
		
	}

}
