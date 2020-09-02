package main.java.笔试.tx;

import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-02 20:34
 */
public class 搬运家具 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
        }
        System.out.println(help(K, N, w, v));
    }

        public static int help(int K, int N, int[] w, int[] v) {
        if (K == 0 || N == 0 || w.length == 0 || v.length == 0) {
            return 0;
        }
        int[] dp = new int[K + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = K; j >= w[i - 1]; j--) {
                dp[j] = Math.max(dp[j - w[i - 1]] + v[i - 1], dp[j]);
            }
        }
        return dp[K];
    }
}
