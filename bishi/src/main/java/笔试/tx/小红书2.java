package main.java.笔试.tx;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-08-30 20:00
 */
public class 小红书2 {

    public static int maxBoxes(int[][] boxes) {
        Arrays.sort(boxes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });

        int[] secondDim = new int[boxes.length];
        for (int i = 0; i < boxes.length; ++i) secondDim[i] = boxes[i][1];
        return lengthOfLIS(secondDim);
    }


    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
            for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }
        res = maxBoxes(_boxes);
        System.out.println(res);

    }
}
