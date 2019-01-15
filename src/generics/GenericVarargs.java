//: generics/GenericVarargs.java
package generics;

import java.util.*;

public class GenericVarargs {
    public static <T>List<T> makeList(T... args){
        List<T> result = new ArrayList<T>();
        for (T arg: args){
            result.add(arg);
        }
        return result;
    }

}
