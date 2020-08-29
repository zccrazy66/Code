package 笔试.jungel.keda;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/8/29 19:03
 */
public class xf01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] sarr = s.split(",");
        int m = Integer.valueOf(sarr[0]);
        int n = Integer.valueOf(sarr[1]);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {  //在原数组中修改
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) arr[i][j] += arr[i][j-1];
                else if (j == 0) arr[i][j] += arr[i-1][j];
                else arr[i][j] += Math.max(arr[i][j-1], arr[i-1][j]);
            }
        }
        System.out.println(arr[m-1][n-1]);
    }
}
