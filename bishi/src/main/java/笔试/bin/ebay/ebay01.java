package bishi.src.main.java.笔试.bin.ebay;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/24.
 */
public class ebay01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long[] dp=new long[n+1];
        dp[1]=1;
        for (int i=2;i<=n;i++){
            int k=0;
            while (i-Math.pow(2,k)>=0){
                dp[i]+=dp[(int)(i-Math.pow(2,k))];

                k++;
            }
        }
       // System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);

    }
}
