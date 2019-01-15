package thinkinjava.chp8;
import java.awt.*;

import static net.mindview.util.Print.*;

class Cycle{
    public void ride(){
        print("I am riding a cycle!");
    }
}

class Unicycle extends Cycle{
    public void ride(){
        print("I am riding a Unicycle!");
    }
}

class Bicycle extends Cycle{
    public void ride(){
        print("I am riding a Bicycle!");
    }
}

class Tricycle extends Cycle{
    public void ride(){
        print("I am riding a Tricycle!");
    }
}

public class c8q1 {
    public static void excersize(Cycle i){
        i.ride();
    }
    public static void main(String args[]){
        Tricycle t = new Tricycle();
        excersize(t);
    }
}
