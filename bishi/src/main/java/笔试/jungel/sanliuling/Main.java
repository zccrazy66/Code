package 笔试.jungel.sanliuling;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] a={10};
        int amount=10;
        System.out.println(change(amount,a));
    }
    public static int change(int amount, int[] coins) {
            int[][] dp=new int[coins.length+1][amount+1];
            dp[0][0]=1;
            for (int i=0;i<coins.length+1;i++){
                dp[i][0]=1;
            }
            for (int i=1;i<coins.length+1;i++){
                for (int j=1;j<amount+1;j++){
                    for (int k=0;k<=j/coins[i-1];k++){
                        dp[i][j]+=dp[i-1][j-k*coins[i-1]];
                       // System.out.println("i="+i+"j="+j+" "+"k="+k+" "+ dp[i][j]);
                    }
                }
            }
            return dp[coins.length][amount];
    }

}
