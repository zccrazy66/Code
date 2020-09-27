package main.java.笔试.Webank;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/27 19:43
 */
public class wb01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int time = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] targets = new int[time];
        for (int i = 0; i < time; i++) {
            targets[i] = scanner.nextInt();
        }
        int[] res = new int[time];
        int[] helper = new int[time];
        for (int i = 0; i < time; i++) {
            helper[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < time; i++) {
            int target = targets[i];
            for (int j = 0; j < n; j++) {
                if (Math.abs(target - arr[j]) < helper[i]){
                    helper[i] = Math.abs(target - arr[j]);
                    res[i] = arr[j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }

    }
}
