package main.java.笔试.tx;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-01 20:06
 */
public class PDD04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] character = new int[M];
        for (int i = 0; i < M; i++) {
            character[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.size();
        System.out.println(help(N, M, character));
    }

    public static int help(int N, int M, int[] character) {
        int num = 0;
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = character[j];
                if (i % tmp == 0) {
                    num++;
                    flag = true;
                    break;
                }
            }
            if(flag){
                flag = false;
            }
        }
        return num;
    }
}
