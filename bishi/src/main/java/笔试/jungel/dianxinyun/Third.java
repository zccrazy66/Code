package 笔试.jungel.dianxinyun;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Third {

    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            if ("push".equals(s1[0])) {
                push(Integer.parseInt(s1[1]));
            }else if("pop".equals(s1[0])) {
                pop();
            }else if("top".equals(s1[0])) {
                int top = top();
                list.addLast(top);
            }else {
                int min = getMin();
                list.addLast(min);
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    private static void push(int x) {
        stack.push(x);
        queue.add(x);
    }

    private static void pop() {
        Integer pop = stack.pop();
        queue.remove(pop);
    }

    private static int top() {
        return stack.peek();
    }

    private static int getMin() {
        return queue.peek();
    }
}
