package main.java.笔试.zczc.滴滴;

import java.util.Scanner;

public class didi01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        System.out.println(solution(input, k));
    }

    private static String solution(String input, int k){
        StringBuilder temp = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int length = input.length();
        int count = 0;
        while (count + k < length){
            String inner = input.substring(count, count + k);
            temp.append(inner);
            res.append(temp.reverse());
            temp.delete(0,temp.length());
            count = count + k ;
        }
        String c = input.substring(count,length);
        temp.append(c);
        res.append(temp.reverse());
        return res.toString();
    }
}
