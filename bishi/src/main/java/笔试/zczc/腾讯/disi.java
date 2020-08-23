package main.java.笔试.zczc.腾讯;

import java.util.Scanner;

public class disi {
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        helper(arr, n);
        System.out.println(res);
    }
    public static void helper(int[] arr, int n) {
        if (n < 1) return;
        if (n == 1) {
            res++;
            return;
        }
        if (n == 2) {
            if (arr[0] == 1 && arr[1] == 1) {
                res++;
                return;
            } else {
                res += 2;
                return;
            }
        }
        int tmp_min = arr[0];
        for (int i = 1; i < n; i++) {
            if (tmp_min > arr[i]) tmp_min = arr[i];
        }
        res += tmp_min;
        int cut_point = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == tmp_min) {
                cut_point = i;
            }
            arr[i] = arr[i] - tmp_min;
        }
        //分裂数组
        int[] arr1 = new int[cut_point];
        int[] arr2 = new int[n-cut_point-1];
        for (int i = 0; i < cut_point; i++) {
            arr1[i] = arr[i];
        }
        for (int i = 0; i < n-cut_point-1; i++) {
            arr2[i] = arr[i+cut_point+1];
        }
        helper(arr1, cut_point);
        helper(arr2, n-cut_point-1);
    }
}