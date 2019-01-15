//: relect/Demo2.java
package reflect;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

// ????????????,??????????
public class Demo2 {
    public static void main(String[] args) {


    }

    @Test
    public void test1() throws Exception {

        Class<?> aClass = Class.forName("reflect.Person");
        Constructor<?> aClassConstructor = aClass.getConstructor(null);

        Person aIns1 = (Person) aClassConstructor.newInstance();

        System.out.println(aIns1.name);

    }

    @Test
    public void test2() throws Exception {

        Class<?> aClass = Class.forName("reflect.Person");

        Constructor<?> aClassConstructor = aClass.getConstructor(String.class);

        Person o = (Person) aClassConstructor.newInstance("name");

        System.out.println(o.name);
    }

    @Test
    public void test3() throws Exception {

        Class<?> aClass = Class.forName("reflect.Person");

        Constructor<?> aClassConstructor = aClass.getConstructor(String.class, int.class);

        Person o = (Person) aClassConstructor.newInstance("hahaha", 2);

        System.out.println(o.name);
    }

    @Test
    public void tst4() throws Exception {

        Class<?> aClass = Class.forName("reflect.Person");

        // ?????§Ô??
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(List.class);
        // ????????
        declaredConstructor.setAccessible(true);

        Person p = (Person)declaredConstructor.newInstance(new ArrayList());

        System.out.println(p.name);
    }
}
