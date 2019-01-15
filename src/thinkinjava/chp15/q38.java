//: thinkinjava/chap15/q38.java
package thinkinjava.chp15;

/** 装饰器设计模式
 * @author jumormt
 * @version 1.0
 */

class BasicCoffee{
    private String type;
    public BasicCoffee(){

    }

    public BasicCoffee(String type){
        setType(type);
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class BasicCoffeeD extends BasicCoffee{

    protected BasicCoffee basic;

    BasicCoffeeD(BasicCoffee b){
        this.basic = b;
    }
    @Override
    public void setType(String type) {
        basic.setType(type);
    }

    @Override
    public String getType() {
        return basic.getType();

    }
}

class SteamedMilk extends BasicCoffeeD{

    public SteamedMilk(BasicCoffee b){
        super(b);
        setType(getType() + " & steamed Milk");
    }
}


public class q38 {
}
