package reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.logging.FileHandler;

public class Demo4 {

    @Test
    public void test1() throws Exception {

        Class<?> aClass = Class.forName("reflect.Person");
        Field name = aClass.getField("name");
        Object nam = name.get(aClass.newInstance());
        Class typ = name.getType();

        if (typ.equals(String.class)) {
            String value = (String) nam;
        }
        Person p = new Person();
        name.set(p, "XXXX");

        System.out.println(p.name);

    }

    @Test
    public void test2() throws Exception{
        Person p = new Person();
        Class<?> aClass = Class.forName("reflect.Person");

        Field f = aClass.getDeclaredField("password");
        f.setAccessible(true);
        Object password = f.get(p);
        Class tp = f.getType();
        if (tp.equals(int.class)) {
            int a = (int) password;
            System.out.println(a);
        }
    }

    @Test
    public void test3() throws Exception{
        Class<?> aClass = Class.forName("reflect.Person");

        Field f = aClass.getDeclaredField("age");
        f.setAccessible(true);
        Object age = f.get(null);
        Class tp = f.getType();
        if (tp.equals(int.class)) {
            int a = (int) age;
            System.out.println(a);
        }
    }
}
