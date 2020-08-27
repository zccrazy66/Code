package main.java.笔试.joey.ZTE;

        import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/8/27 10:40
 */
public class zte01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextLong();
            }
        }
//        System.out.println(arr[2][2]);
        long res = Long.MIN_VALUE;
        for (int i = 1; i < n -1; i++) {
            for (int j = 1; j < m -1; j++) {
                res = Math.max(res, arr[i][j]+arr[i-1][j]+arr[i+1][j]+arr[i][j-1]+arr[i][j+1]);
            }
        }
        System.out.println(res);

    }
}
