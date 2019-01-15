package enumration;

import org.junit.Test;

enum Grade {
    A("100-90"){
        @Override
        public String localValue() {
            return "you";
        }
    }
    ,
    B("89-80") {
        @Override
        public String localValue() {
            return "liang";
        }
    };

    private String value;

    private Grade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract String localValue();
}

//class Grade {
//    private String vaule;
//
//    private Grade(String value) {
//        this.vaule = value;
//    }
//
//    public static final Grade A = new Grade("100-90");
//}

public class Demo1 {
    public static void main(String[] args) {


    }

    @Test
    public void test() {
        print(Grade.A);
    }

    @Test
    public void test2() {
        System.out.println(Grade.A.name());
        System.out.println(Grade.A.ordinal());
//        System.out.println(Grade.values());
        Grade v = Grade.valueOf("A");
        System.out.println(v);
    }

    public void print(Grade grade) {
        String value = grade.localValue();
        System.out.println(value);
    }


}

