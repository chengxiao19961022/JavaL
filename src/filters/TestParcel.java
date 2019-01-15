package filters;

interface Contents{
    int value();
}
interface Destination{
    String readLabel();
}

public class TestParcel {
    private class PContents implements Contents {
        private int i = 11;
        public int value() { return i; }
    }
    public class PDestination implements Destination {
        private String label;
        public PDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() { return label; }
    }
    public static void main(String[] args) {
        TestParcel p = new TestParcel();
        Contents c = p.new PContents();
        Destination d = p.new PDestination("Tasmania");
        // Illegal -- can't access private class:
//        Parcel4.PContents pc = p.new PContents();
    }
} ///:~
