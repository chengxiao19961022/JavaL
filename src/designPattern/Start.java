package designPattern;

/**
 * http://www.cnblogs.com/malihe/p/6891920.html
 * Java中23种设计模式--超快速入门及举例代码
 *
 */

public class Start {
    /**
     * java的设计模式大体上分为三大类：
     * 创建型模式（5种）：工厂方法模式，抽象工厂模式，单例模式，建造者模式，原型模式。
     * 结构型模式（7种）：适配器模式，装饰器模式，代理模式，外观模式，桥接模式，组合模式，享元模式。
     * 行为型模式（11种）：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
     * 设计模式遵循的原则有6个：
     * 1、开闭原则（Open Close Principle）
     * <p>
     * 　　对扩展开放，对修改关闭。
     * <p>
     * 2、里氏代换原则（Liskov Substitution Principle）
     * <p>
     * 　　只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。
     * <p>
     * 3、依赖倒转原则（Dependence Inversion Principle）
     * <p>
     * 　　这个是开闭原则的基础，对接口编程，依赖于抽象而不依赖于具体。
     * <p>
     * 4、接口隔离原则（Interface Segregation Principle）
     * <p>
     * 　　使用多个隔离的借口来降低耦合度。
     * <p>
     * 5、迪米特法则（最少知道原则）（Demeter Principle）
     * <p>
     * 　　一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。
     * <p>
     * 6、合成复用原则（Composite Reuse Principle）
     * <p>
     * 　　原则是尽量使用合成/聚合的方式，而不是使用继承。继承实际上破坏了类的封装性，超类的方法可能会被子类修改。
     */

    public Start() {
        System.out.println("this is the start of pattern");
        System.out.println("java的设计模式大体上分为三大类：\n" +
                "创建型模式（5种）：工厂方法模式，抽象工厂模式，单例模式，建造者模式，原型模式。\n" +
                "结构型模式（7种）：适配器模式，装饰器模式，代理模式，外观模式，桥接模式，组合模式，享元模式。\n" +
                "行为型模式（11种）：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。\n" +
                "设计模式遵循的原则有6个：\n" +
                "1、开闭原则（Open Close Principle）\n" +
                "\n" +
                "　　对扩展开放，对修改关闭。\n" +
                "\n" +
                "2、里氏代换原则（Liskov Substitution Principle）\n" +
                "\n" +
                "　　只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。\n" +
                "\n" +
                "3、依赖倒转原则（Dependence Inversion Principle）\n" +
                "\n" +
                "　　这个是开闭原则的基础，对接口编程，依赖于抽象而不依赖于具体。\n" +
                "\n" +
                "4、接口隔离原则（Interface Segregation Principle）\n" +
                "\n" +
                "　　使用多个隔离的借口来降低耦合度。\n" +
                "\n" +
                "5、迪米特法则（最少知道原则）（Demeter Principle）\n" +
                "\n" +
                "　　一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。\n" +
                "\n" +
                "6、合成复用原则（Composite Reuse Principle）\n" +
                "\n" +
                "　　原则是尽量使用合成/聚合的方式，而不是使用继承。继承实际上破坏了类的封装性，超类的方法可能会被子类修改。");
    }

    public static void main(String[] args) {
        new Start();
    }
}
