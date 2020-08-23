package main.java.笔试.zczc.腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int Q = in.nextInt();
        List list = new ArrayList();
        while (Q > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            list.add(minCut(s.substring(l - 1,r)));
            Q--;
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }

        public static int minCut(String s){
            int n = s.length();
            boolean[][] check = new boolean[n + 1][n + 1];
            int[] dp = new int[n + 1];
            char[] cs = s.toCharArray();
            int j;
            //初始化， 把所有是回文串的放入check 数组， 根据i和j就能判断子串s[i,j]是否回文串
            for(int len = 1; len <= n; len++){
                for(int i = 1; i + len - 1 <= n; i++){
                    j = i + len - 1;
                    if(len == 1)    {
                        check[i][j] = true;
                    }else{
                        if(cs[i - 1] == cs[j - 1]) {
                            check[i][j] = len == 2 || check[i + 1][j - 1];
                        }
                    }
                }
            }
            dp[0] = -1;
            for(int i = 1; i <= n; i++){
                dp[i] = dp[i - 1] + 1;
                for(int k = 1; k < i; k++){
                    if(check[k][i]){
                        dp[i] = Math.min(dp[i], dp[k - 1] + 1);
                    }
                }
            }
            return dp[n] + 1;
        }


}
