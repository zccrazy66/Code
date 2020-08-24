package main.java.笔试.zczc.阿里;

import java.util.Scanner;

public class ali1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextInt();
        long B = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        if (A * b == B * a){
            System.out.println(A + " " + B);
            return;
        }else if (A < a && B < b){
            System.out.println("0 0");
            return;
        }

        if (a > b){
            for (long i = A; i >= 0 ; i--) {
                if (i * b % a == 0){
                    System.out.println(i + " " + i*b / a);
                    return;
                }
            }
        }else if (a < b){
            for (long i = B; i >= 0 ; i--) {
                if (i * a % b == 0){
                    System.out.println(i*a/b + " " + i);
                    return;
                }
            }
        }
        System.out.println("0 0");
    }

}
