package introspector;

public class Person {

    private String name;  //字段（当字段有完整的getter和setter方法时就叫 属性），属性由set/get决定
    private String password;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getAb() { // Ab属性
        return null;
    }
}
