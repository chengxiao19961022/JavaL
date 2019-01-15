package reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class Demo3 {
    @Test
    public void test1() throws Exception {
        Class<?> aClass = Class.forName("reflect.Person");
        Method aa1 = aClass.getMethod("aa1", null);

        aa1.invoke(aClass.newInstance(), null);
    }

    @Test
    public void test2() throws Exception {
        Class<?> aClass = Class.forName("reflect.Person");
        Method aa1 = aClass.getMethod("aa1", String.class, int.class);

        aa1.invoke(aClass.newInstance(), "cx", 22);
    }

    @Test
    public void test3() throws Exception {
        Class<?> aClass = Class.forName("reflect.Person");
        Method aa1 = aClass.getMethod("aa1", String.class, int[].class);

//        aa1.setAccessible(true);
        Class[] cx = (Class[]) aa1.invoke(aClass.newInstance(), "cx", new int[]{1, 23});
        System.out.println(cx[0]);
    }

//    @Test
//    public void test4() throws Exception {
//        Class<?> aClass = Class.forName("reflect.Person");
//        Method aa1 = aClass.getDeclaredMethod("aa1", InputStream.class);
//        aa1.setAccessible(true);
////        aa1.setAccessible(true);
//        aa1.invoke(aClass.newInstance(), new FileInputStream(""));
//    }

    @Test
    public void test5() throws Exception {
        Class<?> aClass = Class.forName("reflect.Person");
        Method aa1 = aClass.getMethod("aa1", int.class);
        aa1.invoke(null, 23);
    }

    @Test
    public void test6() throws Exception {
        Class<?> aClass = Class.forName("reflect.Person");
        Method aa1 = aClass.getMethod("main", String[].class);
//        aa1.invoke(null, new Object[]{new String[]{"aa", "bb"}});
        aa1.invoke(null, (Object)new String[]{"aa", "bb"});

    }


}
