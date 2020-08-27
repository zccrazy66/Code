package 笔试.jungel.zhongxing;

import com.alibaba.fastjson.JSON;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n<3||m<3) {
            System.out.println(0);
            return;
        }
        scanner.nextLine();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j]=scanner.nextInt();
            }
        }

        int max = new First().getMax(grid);
        System.out.println(max);


    }


    private int getMax(int[][] grid) {

        int m = grid.length;
        int n = grid.length;

        int max = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {

                int res = grid[i][j] + grid[i - 1][j] + grid[i + 1][j] + grid[i][j - 1] + grid[i][j + 1];
                if (res > max) max = res;
            }
        }

        return max;
    }
}
