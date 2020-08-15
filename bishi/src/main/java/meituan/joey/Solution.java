package meituan.joey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 第四题：利润最大
 * @author JoeyChen
 * @data 2020/8/15 14:36
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int[] arr_a = new int[n];
        int[] arr_b = new int[n];
        for (int i = 0; i < n; i++) {
            arr_a[i] = nums[i][0];
            arr_b[i] = nums[i][1];
        }
        Arrays.sort(arr_a);
        Arrays.sort(arr_b);


        int res = 0;

        int flag_a = 0;
        while (a > 0) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i][0] == arr_a[n-1-flag_a])
                    temp.add(i);
            }
            int label_a = temp.get(0);
            for (int i = 0; i < temp.size()-1; i++) {
                if (nums[temp.get(i)][1] <= nums[temp.get(i+1)][1] && nums[temp.get(i)][1] != 0) {
                    label_a = temp.get(i);
                    System.out.println(label_a);
                } else if (nums[temp.get(i)][1] > nums[temp.get(i+1)][1] && nums[temp.get(i+1)][1] != 0) {
                    label_a = temp.get(i+1);
                    System.out.println(label_a);
                }
            }
            res += nums[label_a][0];
            nums[label_a][1] = 0;
            flag_a++;
            a--;
        }
        int flag_b = 0;
        while (b > 0) {
            for (int i = 0; i < n; i++) {
                if (nums[i][1] != 0 && nums[i][1] == arr_b[n-1-flag_b]) {
                    res += nums[i][1];
                    b--;
                }
            }
            flag_b++;
        }
        System.out.println(res);
    }

 }
