package filters;


import java.util.*;
import static net.mindview.util.Print.*;

interface Processor {
    public String name();
    Object process(Object input);
}


public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
}
