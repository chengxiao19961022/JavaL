package introspector;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class Demo1 {

    @Test
    public void test1() throws Exception {
        System.out.println("Äã");

//        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor pd : propertyDescriptors) {
            System.out.println(pd.getName());

        }
    }

    @Test
    public void test2() throws Exception {

        Person person = new Person();

        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);

        Method writeMethod = pd.getWriteMethod();
        writeMethod.invoke(person, 45);

        Method readMethod = pd.getReadMethod();
        System.out.println(readMethod.invoke(person, null));
    }

    @Test
    public void test3() throws Exception {

        Person person = new Person();

        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        System.out.println(pd.getPropertyType());
    }
}
