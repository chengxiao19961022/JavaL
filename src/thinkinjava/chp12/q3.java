package thinkinjava.chp12;

class ResumerException extends Exception {}
class Resumer {
    static int count = 3;
    static void f() throws ResumerException {
        if(--count > 0)
            throw new ResumerException();
    }
}
public class q3 {
    public static void main(String args[]) {
        while(true) {
            try {
                Resumer.f();
            } catch(ResumerException e) {
                System.out.println("Caught " + e);
                continue;
            }
            System.out.println("Got through...");
            break;
        }
        System.out.println("Successful execution");
    }
}