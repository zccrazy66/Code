package 笔试.jungel.pinduoduo;


import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] grid = new int[n][n];

        // 填充区域1
        for (int i = 0; i < n / 2; i++) {
            for (int j = (n / 2); j < n-i-1; j++) {
                grid[i][j] = 1;
            }
        }

        // 填充区域2
        for (int i = 0; i < (n / 2); i++) {
            for (int j = i+1; j < n / 2; j++) {
                grid[i][j] = 2;
            }
        }

        // 填充区域3
        for (int i = 1; i < n / 2; i++) {
            for (int j = 0; j < i; j++) {
                grid[i][j] = 3;
            }
        }

        // 填充区域4
        for (int i = (n / 2); i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                grid[i][j] = 4;
            }
        }

        // 填充区域5
        for (int i = (n / 2)+1; i < n; i++) {
            for (int j = n-i-1+1; j < n/2; j++) {
                grid[i][j] = 5;
            }
        }

        // 填充区域6
        for (int i = (n / 2)+1; i < n; i++) {
            for (int j = (n/2); j < i; j++) {
                grid[i][j] = 6;
            }
        }

        // 填充区域7
        for (int i = (n / 2); i < n; i++) {
            for (int j = i+1; j < n; j++) {
                grid[i][j] = 7;
            }
        }

        // 填充区域8
        for (int i = 1; i < n / 2; i++) {
            for (int j = (n-i-1+1); j < n; j++) {
                grid[i][j] = 8;
            }
        }

        // 填充矩阵
        if (n%2==1) {
            // 奇数
            for (int i = 0; i < n; i++) {
                grid[n/2][i]=0;
                grid[i][n/2]=0;
            }

            for (int i = 0; i < n; i++) {
                grid[i][i]=0;
                grid[i][i]=0;
            }

            for (int i = 0; i < n; i++) {
                grid[i][n-i-1]=0;
            }
        }

        for (int i = 0; i < n; i++) {

            for (int o : grid[i]) {
                System.out.print(o+" ");
            }
            System.out.println();
        }
    }
}
