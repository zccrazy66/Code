package main.java.笔试.zczc.百度;

import java.util.Scanner;

public class 走台阶 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(solution(n,m));
    }

    private static int solution(int n, int m){
        if (m == 2){
            return 0;
        }
        if (m == 3 && n % 6 == 0){
            return 3;
        }else {
            return 2;
        }

    }
}
