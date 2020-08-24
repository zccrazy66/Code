package Code.bishi.src.main.java.笔试.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/23.
 */
public class TX01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int[][] nums=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                nums[i][j]=s.nextInt();
            }
        }
        int[][] dp=new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                int max=Integer.MIN_VALUE;
                for (int k=0;k<=j;k++){
                    if (k==0){
                        dp[i][j]=dp[i-1][j];
                    }
                    else {
                        //System.out.println("i"+"="+i+"j="+j+"k="+k);
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k]+nums[i-1][k-1]);
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
