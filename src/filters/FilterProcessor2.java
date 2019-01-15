//: filters/FilterProcessor2.java
package filters;

import net.mindview.util.Print.*;

class FilterAdapter2 extends Filter implements Processor {

    public FilterAdapter2(){

    }

    @Override
    public String name() {
        return super.name();
    }

    @Override
    public Waveform process(Object input) {
        return super.process((Waveform) input);
    }

}
public class FilterProcessor2 {
    public static void main(String args[]){
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(
                new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }
}
