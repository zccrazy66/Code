package main.java.笔试.zczc.浪潮;

import java.util.Scanner;

public class 石头 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt();
            int []arr = new int[m];
            for(int i = 0; i < m; i ++){
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[m + 1];
            int res = 0;
            for(int num : arr) {
                dp[num] = dp[num - 1] + 1;
                res = Math.max(dp[num], res);
            }
            System.out.println(m - res);
        }
    }
}
