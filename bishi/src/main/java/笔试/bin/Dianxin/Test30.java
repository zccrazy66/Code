package bishi.src.main.java.笔试.bin.Dianxin;

import java.util.Stack;

/**第三题？？？？？？
 * Created by 林松斌的船 on 2020/7/31.
 */
public class Test30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}

class MinStack {
     Stack<Integer>A,B;
    /** initialize your data structure here. */
    public MinStack() {
        A=new Stack<>();
        B=new Stack<>();

    }

    public void push(int x) {

            this.A.push(x);
            if(B.empty()||B.peek()>=x){
                B.push(x);
            }
    }

    public void pop() {
            int a=A.pop();
            if (a==B.peek()){
                B.pop();
            }
    }

    public int top() {
        return A.peek();

    }

    public int getMin() {
        return B.peek();
    }
}
