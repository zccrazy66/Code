package 笔试.jungel.xiaohongshu;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Second {

    private static class Box{
        int height;
        int radius;

        public Box(int height, int radius) {
            this.height = height;
            this.radius = radius;
        }
    }
    static int maxBoxes(int[][] boxes) {

        // 行
        int m = boxes.length;

        PriorityQueue<Box> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.height));

        for (int i = 0; i < m; i++) {
            queue.add(new Box(boxes[i][0],boxes[i][1]));
        }

        int[] arr = new int[m];
        int i =0;
        while (queue.size()!=0) {
            Box box = queue.remove();
            arr[i] = box.radius;
            i++;
        }

        int res = lengthOfLIS(arr);
        return res;
    }

    /**
     * 最长上升子序列
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int boxes_rows=0;
        int boxes_cols=0;
        boxes_rows = Integer.parseInt(in.nextLine().trim());
        boxes_cols = Integer.parseInt(in.nextLine().trim());
        int[][] boxes = new int[boxes_rows][boxes_cols];
        for (int boxes_i = 0; boxes_i < boxes_rows; boxes_i++) {
            for (int boxes_j = 0; boxes_j < boxes_cols; boxes_j++) {
                boxes[boxes_i][boxes_j] = in.nextInt();
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        res = maxBoxes(boxes);
        System.out.println(String.valueOf(res));
    }
}
