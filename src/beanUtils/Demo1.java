package beanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public class Demo1 {

    @Test
    public void test1() throws Exception {
        Person person = new Person();
        BeanUtils.setProperty(person, "name", "xxl");

        System.out.println(person.getName());
    }

    @Test
    public void test2() throws Exception {
        String name = "aa";
        String password = "1234";
        String age = "34";
        String birthday = "1970-09-30";

        Person p = new Person();
        BeanUtils.setProperty(p, "name", name);
        BeanUtils.setProperty(p, "password", password);
        BeanUtils.setProperty(p, "age", age); // 只支持8种基本数据类型
        BeanUtils.setProperty(p, "birthday", birthday); // 只支持8种基本数据类型

        System.out.println(p.getAge());

    }

    @Test
    public void test3() throws Exception {
        String name = "aa";
        String password = "1234";
        String age = "34";
        String birthday = "1970-09-30";

        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> aClass, Object o) {
                if (o == null) {
                    return null;
                }

                if (!(o instanceof String)) {
                    throw new ConversionException("只支持String的转化！");
                }

                String str = (String) o;
                if (str.trim().equals("")) {
                    return null;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return (T) df.parse(str);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
        }, Date.class);

        Person p = new Person();
        BeanUtils.setProperty(p, "name", name);
        BeanUtils.setProperty(p, "password", password);
        BeanUtils.setProperty(p, "age", age); // 只支持8种基本数据类型
        BeanUtils.setProperty(p, "birthday", birthday); // 只支持8种基本数据类型

        Date a = p.getBirthday();
        System.out.println(a.toLocaleString());

    }

    @Test
    public void test4() throws Exception {
        String name = "aa";
        String password = "1234";
        String age = "34";
        String birthday = "1970-9-30";

        ConvertUtils.register(new DateLocaleConverter(), Date.class);

        Person p = new Person();
        BeanUtils.setProperty(p, "name", name);
        BeanUtils.setProperty(p, "password", password);
        BeanUtils.setProperty(p, "age", age); // 只支持8种基本数据类型
        BeanUtils.setProperty(p, "birthday", birthday); // 只支持8种基本数据类型

        Date a = p.getBirthday();
        System.out.println(a.toString());

    }

    @Test
    public void test5() throws Exception {

        Map mp = new HashMap();
        mp.put("name", "aa");
        mp.put("password", "1234");
        mp.put("age", "33");
        mp.put("birthday", "1970-09-30");
        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> aClass, Object o) {
                if (o == null) {
                    return null;
                }

                if (!(o instanceof String)) {
                    throw new ConversionException("只支持String的转化！");
                }

                String str = (String) o;
                if (str.trim().equals("")) {
                    return null;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return (T) df.parse(str);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
        }, Date.class);

        Person p = new Person();
        BeanUtils.populate(p, mp);
        System.out.println(p.getBirthday());
    }
}
