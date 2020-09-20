package main.java.笔试.bin.Dianxin;

import java.util.Scanner;
import java.util.Stack;

/**第三题？？？？？？
 * Created by 林松斌的船 on 2020/7/31.
 */
public class Test30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLine();
        }
        MinStack minStack = new MinStack();
        for (int i = 0; i < n; i++) {
            String type = input[i].split(" ")[0];
            if (type.equals("push")){
               minStack.push(Integer.parseInt(input[i].split(" ")[1]));
            }else if (type.equals("getMin")){
                System.out.println(minStack.getMin());
            }else if (type.equals("pop")){
                minStack.pop();
            }else{
                System.out.println(minStack.top());
            }
        }
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
