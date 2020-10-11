package main.java.笔试.Webank;

import java.util.Arrays;
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
        Arrays.sort(arr);  //从小到大

        int[] targets = new int[time];
        for (int i = 0; i < time; i++) {
            targets[i] = scanner.nextInt();
        }

        int[] res = new int[time];
        for (int i = 0; i < time; i++) {
            res[i] = -1;
        }

//        int[] helper = new int[time];  //存储差值绝对值
//        for (int i = 0; i < time; i++) {
//            helper[i] = Integer.MAX_VALUE;
//        }


        for (int i = 0; i < time; i++) {
            int target = targets[i];
            int left = 0, right = n -1;
            int tmp_left = -1, tmp_right = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    res[i] = arr[mid];
                    break;
                }
                if (arr[mid] > target) {
                    tmp_right = arr[mid];
                    right = mid - 1;

                }
                if (arr[mid] < target) {
                    tmp_left = arr[mid];
                    left = mid + 1;
                }
            }
            if (tmp_left > -1 || tmp_right > -1) {
                if (res[i] == -1 && tmp_left > -1 && tmp_right > -1) {
                    res[i] = Math.abs(tmp_right - target) < Math.abs(tmp_left - target) ? tmp_right : tmp_left;
                }
                if (res[i] == -1 && tmp_left > -1) {
                    res[i] = tmp_left;
                }
                if (res[i] == -1 && tmp_right > -1) {
                    res[i] = tmp_right;
                }
            }
        }


        for (int i = 0; i < time; i++) {
            System.out.println(res[i]);

        }
    }
}
