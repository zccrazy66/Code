package main.java.笔试.joey;


import java.util.Scanner;
import java.util.Arrays;


public class huawei01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] res = new int[N*N][2];
        if (M == 0 || N == 0) System.out.println("[[]]");
        int index = 0;
        int sign_row = 0;

        int row_up = 0, row_bottom = M -1, col_left = 0, col_right = N -1;

        while (row_up <= row_bottom && col_left <= col_right) {
            for (int j = col_left; j <= col_right; j++) {
                index++;
                if (index % 10 == 7 && index / 10 % 10 % 2 == 1) {
                    res[sign_row][0] = row_up;
                    res[sign_row][1] = j;
                    sign_row++;
                }
            }
            row_up++;
            for (int i = row_up; i <= row_bottom; i++) {
                index++;
                if (index % 10 == 7 && index / 10 % 10 % 2 == 1) {
                    res[sign_row][0] = i;
                    res[sign_row][1] = col_right;
                    sign_row++;
                }
            }
            col_right--;

            if (row_up <= row_bottom && col_left <= col_right) {
                for (int j = col_right; j >= col_left; j--) {
                    index++;
                    if (index % 10 == 7 && index / 10 % 10 % 2 == 1) {
                        res[sign_row][0] = row_bottom;
                        res[sign_row][1] = j;
                        sign_row++;
                    }
                }
                row_bottom--;
                for (int i = row_bottom; i >= row_up; i--) {
                    index++;
                    if (index % 10 == 7 && index / 10 % 10 % 2 == 1) {
                        res[sign_row][0] = i;
                        res[sign_row][1] = col_left;
                        sign_row++;
                    }
                }
                col_left++;
            }
        }
        int n = 0;
        for (int i = 0; i < N*N; i++) {
            if (res[i][0] == 0 && res[i][1] == 0) {
                n = i;
                break;
            }
        }
        int [][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = res[i][0];
            ans[i][1] = res[i][1];
        }
        System.out.print("[");
        for (int i = 0; i < n-1; i++) {
            System.out.print("["+ans[i][0] +","+ ans[i][1]+"]"+",");

        }
        System.out.print("["+ans[n-1][0] +","+ ans[n-1][1]+"]");
        System.out.print("]");
    }
}