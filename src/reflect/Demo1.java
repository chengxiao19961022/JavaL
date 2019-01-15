package reflect;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("reflect.Person");

        Class<? extends Person> clazz1 = new Person().getClass();

        Class<Person> clazz2 = Person.class;


    }
}



