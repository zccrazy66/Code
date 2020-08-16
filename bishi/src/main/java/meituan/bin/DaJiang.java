package Code.bishi.src.main.java.meituan.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/16.
 */
public class DaJiang {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();
        int x=s.nextInt();
        int[] weight=new int[n];
        int[] value=new int[n];
        for (int i=0;i<n;i++){
            value[i]=s.nextInt();
            weight[i]=s.nextInt();
        }
        DaJiang daJiang02=new DaJiang();
        System.out.println(daJiang02.help(x,n,weight,value));

    }
    public  int help(int V,int N,int[] weight,int[] value){

        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
            }
        }
        int maxValue = dp[N][V];
        return maxValue;
    }

}
