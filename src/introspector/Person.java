package introspector;

public class Person {

    private String name;  //�ֶΣ����ֶ���������getter��setter����ʱ�ͽ� ���ԣ���������set/get����
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

    public String getAb() { // Ab����
        return null;
    }
}
