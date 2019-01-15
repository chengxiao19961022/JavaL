package thinkinjava.chp10;
import net.mindview.util.Print.*;
//import org.omg.CORBA.Current;

interface Cycle{
    int wheels();
}

interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle{

    @Override
    public int wheels(){
        return 1;
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle{
    @Override
    public int wheels() {
        return 2;
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle{
    @Override
    public int wheels() {
        return 4;
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}
public class c10q16 {
    public static void ride(CycleFactory fact) {
        Cycle c = fact.getCycle();
        System.out.println("Num. of wheels: " + c.wheels());
    }
    public static void main(String[] args) {
        ride(Unicycle.factory);
        ride(Bicycle.factory);
        ride(Tricycle.factory);
    }
}
