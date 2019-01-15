//: generics/LinkedStack.java
package generics;

/** 使用内部类实现堆栈
 * @author jumormt
 * @version 1.0
 */


/** 堆栈类 */
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
         * @param 无
         * @return 栈是否为空
         */
        boolean end(){
            return item==null&&next==null;
        }
    }

    /** 栈顶指针 */
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
     * @return 抛出元素
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
