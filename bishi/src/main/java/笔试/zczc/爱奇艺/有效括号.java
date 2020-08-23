package main.java.笔试.zczc.爱奇艺;

import java.util.Scanner;
import java.util.Stack;

public class 有效括号 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(isValid(input));
    }
    public static String isValid(String s) {
        if (s.length() % 2 == 1)
            return "False";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char theChar = s.charAt(i);
            if (theChar == '(' || theChar == '{' || theChar == '[')
                stack.push(theChar);
            else {
                if (stack.empty())
                    return "False";
                char preChar = stack.peek();
                if ((preChar == '{' && theChar == '}') || (preChar == '(' && theChar == ')') || (preChar == '[' && theChar == ']'))
                    stack.pop();
                else return "False";
            }
        }
        if (stack.empty()){
            return "True";
        }
        return "False";
    }

}
