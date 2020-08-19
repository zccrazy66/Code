package meituan.jungel;

import java.util.Scanner;

/**
 * 编程协议
 */
public class ByteDance04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 数组个数
        int n = scanner.nextInt();
        // 取余
        int m = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        boolean flag = false;
        for (int i = 0; i < n; i++) {

            int anInt = scanner.nextInt();
            if (anInt % m == m - 1) {

                flag=true;
                break;
            } else {
                arr[i] = anInt % m;
            }

        }

        if (flag) {
            System.out.println(m-1);
        }else {
            int helper = helper(arr, m);
            System.out.println(helper);
        }
    }

    private static int helper(int[] arr,int m) {

        int n = arr.length;
        int[] dp = new int[n+1];

        dp[0] = arr[0];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                int temp = (dp[j]+arr[i])<m?dp[j]+arr[i]:arr[j];
                dp[i] = Math.max(dp[i],temp);
                dp[i] = Math.max(dp[i],arr[j]);
            }
        }
        int res = dp[0];

        for (int i = 0; i < n; i++) {
            res=Math.max(res,dp[i]);
        }

        return res;
    }
}
