package thinkinjava.chap11;
import java.lang.reflect.Array;
import java.util.*;
import static net.mindview.util.Print.*;


public class q1 {


    public static void main(String args[]){
        Collection<Integer> c = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] a = {6,7,8,9};
        Collections.addAll(c, a);
        for (Integer i : c) print(i);

    }
}
