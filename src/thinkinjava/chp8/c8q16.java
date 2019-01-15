package thinkinjava.chp8;
import static net.mindview.util.Print.*;

/** ״̬���� */
class AlertStatus{
    /**
     * �õ�״̬
     *
     * @param ����1 ����1��ʹ��˵��
     * @param none
     * @return ״̬
     * @throws �쳣����.������� ע���Ӵ��෽�����׳��쳣��˵��
     */
    public String getStatus(){
        return "None!";
    }
}



/** ��ɫ���� */
class RedStatus extends AlertStatus{

    /**
     * �õ�״̬
     *
     * @param ����1 ����1��ʹ��˵��
     * @param none
     * @return ��ɫ״̬
     * @throws �쳣����.������� ע���Ӵ��෽�����׳��쳣��˵��
     */
    public String getStatus(){
        return "Red alert!";
    }
}

/** ��ɫ״̬ */
class GreenStatus extends AlertStatus{

    /**
     * ��ɫ״̬
     *
     * @param none
     * @return ��ɫ״̬
     * @throws none
     */
    public String getStatus(){
        return "Green alert!";
    }
}

/** �ɴ� */
class StarShip{

    /** �ɴ�״̬ */
    private AlertStatus status = new GreenStatus();

    /**
     * ���췽������ϸʹ��˵��
     *
     * @param ����1 ����1��ʹ��˵��
     * @throws �쳣����.������� ע���Ӵ��෽�����׳��쳣��˵��
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
 * �����ϸ˵��
 * @author �ഴ��������
 * @Date    ��������
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
