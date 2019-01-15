package generic;

import org.junit.Test;

import java.util.*;

public class Demo1 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

//        List list = new ArrayList();
//        list.add("aaa");
//
//        Integer i = (Integer) list.get(0);
//        System.out.println(i);
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String str : list) {
            System.out.println(str);
        }



    }

    @Test
    public void test1() {
        Map<Integer, String> mp = new HashMap<Integer, String>();
        mp.put(1, "aaa");
        mp.put(2, "bbb");
        mp.put(3, "ccc");

        Set<Map.Entry<Integer, String>> set = mp.entrySet();
        Iterator<Map.Entry<Integer, String>> si = set.iterator();

        while (si.hasNext()) {
            Map.Entry<Integer, String> entry = si.next();
            int key = entry.getKey();
            String vauel = entry.getValue();

            System.out.println(key + "=" + vauel);

        }

        // 增强for循环
        for (Map.Entry<Integer, String> me : mp.entrySet()) {
            System.out.println(me.getKey() + "=" + me.getValue());
        }
    }
}
