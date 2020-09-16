package bishi.src.main.java.笔试.bin.Dianxin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/9.
 */
public class DianXin01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n) {
        //每个数都有乘2，乘3，乘5的数在数组中，三指针分别代表三种乘法，从小往大取三种情况最小的就是一下次的值
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
