package main.java.笔试.joey.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/16 19:35
 */
public class 魔法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int res = method(nums);
        if (res == -1) System.out.println(-1);
        else System.out.println(res*4);
        }

    public static int method(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int avg = sum / 4;
        for (int i = avg; i >= 0; i--) {
            int sub = 0;
            for (int num : nums) {
                if (i < num) sub += (num - i);
            }
            int count = 0;
            for (int num : nums) {
                if (i > num) count += (i - num) * 2;
            }
            if (sub == count) return i;
        }
        return -1;
    }
}