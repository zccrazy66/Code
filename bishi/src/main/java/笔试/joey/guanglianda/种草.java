package main.java.笔试.joey.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/16 19:03
 */
public class 种草 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int m_h = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        while (m > 0) {
            Arrays.sort(arr);
            arr[0] += m_h;
            m--;
        }
        System.out.println(arr[0]);

    }
}
