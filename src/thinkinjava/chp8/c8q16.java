package thinkinjava.chp8;
import static net.mindview.util.Print.*;

/** 状态基类 */
class AlertStatus{
    /**
     * 得到状态
     *
     * @param 参数1 参数1的使用说明
     * @param none
     * @return 状态
     * @throws 异常类型.错误代码 注明从此类方法中抛出异常的说明
     */
    public String getStatus(){
        return "None!";
    }
}



/** 红色警告 */
class RedStatus extends AlertStatus{

    /**
     * 得到状态
     *
     * @param 参数1 参数1的使用说明
     * @param none
     * @return 红色状态
     * @throws 异常类型.错误代码 注明从此类方法中抛出异常的说明
     */
    public String getStatus(){
        return "Red alert!";
    }
}

/** 绿色状态 */
class GreenStatus extends AlertStatus{

    /**
     * 绿色状态
     *
     * @param none
     * @return 绿色状态
     * @throws none
     */
    public String getStatus(){
        return "Green alert!";
    }
}

/** 飞船 */
class StarShip{

    /** 飞船状态 */
    private AlertStatus status = new GreenStatus();

    /**
     * 构造方法的详细使用说明
     *
     * @param 参数1 参数1的使用说明
     * @throws 异常类型.错误代码 注明从此类方法中抛出异常的说明
     */
    public StarShip(AlertStatus s){
        status = s;
    }

    public StarShip(){

    }

    public void setStatus(AlertStatus s){
        status = s;
    }

    public String toString(){
        return status.getStatus();
    }


}



/**
 * Copyright (C), 2006-2010, ChengDu Lovo info. Co., Ltd.
 * FileName: c8q16.java
 * 类的详细说明
 * @author 类创建者姓名
 * @Date    创建日期
 * @version 1.00
 */
public class c8q16 {
    public static void main(String args[]) {
        StarShip eprise = new StarShip();
        System.out.println(eprise);
        eprise.setStatus(new GreenStatus());
        System.out.println(eprise);
        eprise.setStatus(new RedStatus());
        System.out.println(eprise);
    }
}
