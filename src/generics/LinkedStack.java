//: generics/LinkedStack.java
package generics;

/** ʹ���ڲ���ʵ�ֶ�ջ
 * @author jumormt
 * @version 1.0
 */


/** ��ջ�� */
public class LinkedStack<T> {

    /** node */
    private class Node{
        T item;
        Node next;
        Node(){item = null; next = null;}
        Node(T i, Node n){
            item = i;
            next = n;
        }

        /**
         * @param ��
         * @return ջ�Ƿ�Ϊ��
         */
        boolean end(){
            return item==null&&next==null;
        }
    }

    /** ջ��ָ�� */
    private Node top = new Node();

    /**
     *
     * @param item
     */
    public void push(T item) {
        top = new Node(item, top);
    }

    /**
     *
     * @return �׳�Ԫ��
     */
    public T pop(){
        T popItem = top.item;
        if (!top.end()) top = top.next;
        return popItem;
    }

    public static void main(String args[]){
        LinkedStack<String> lss = new LinkedStack<String>();
        for(String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while((s = lss.pop()) != null)
            System.out.println(s);
    }

}
