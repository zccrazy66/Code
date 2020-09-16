package main.java.笔试.joey.guanglianda;

import java.util.*;
/**
 * @author JoeyChen
 * @data 2020/9/16 20:06
 */
public class 魔法22 {
    public static long f(long a,long b,long c,long d){
        long sum = a + b + c + d;
        long avl = sum / 4;
        for (long x = avl; x >= 0; x--) {
            long left = sum - 4 * x;
            long right = 0;
            if (x - a > 0) right += x - a;
            if (x - b > 0) right += x - b;
            if (x - c > 0) right += x - c;
            if (x - d > 0) right += x - d;
            if (left >= right) {
                return 4*x;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        long a = Long.parseLong(s1[0]);
        long b = Long.parseLong(s1[1]);
        long c = Long.parseLong(s1[2]);
        long d = Long.parseLong(s1[3]);
        System.out.println(f(a,b,c,d));
    }
}
