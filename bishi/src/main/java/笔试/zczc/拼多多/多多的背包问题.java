package main.java.笔试.zczc.拼多多;

import java.util.Scanner;

public class 多多的背包问题 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] C = new int[N];
        int[] V = new int[N];

        for (int i = 0; i < N; i++) {
            C[i] = in.nextInt();
            V[i] = in.nextInt();
        }

        System.out.println(solution(M,N,C,V));
    }


    private static int solution(int capacity, int number, int[] weights, int[] value){
        int[][] v = new int[number][capacity];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < capacity; j++) {
                if (i == 0){
                    v[i][j] = 0;
                }else if (j == 0){
                    v[i][j] = 0;
                }else {
                    v[i][j] = Math.max(v[i-1][j], v[i-1][j-weights[i]] + value[i]);
                }
            }
        }
        return v[number - 1][capacity - 1];
    }

}
