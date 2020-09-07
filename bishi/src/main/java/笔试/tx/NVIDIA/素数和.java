package main.java.笔试.tx.NVIDIA;

import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-07 19:35
 */
public class 素数和 {
    public static void main(String[] args) {
        int number = 100000 + 1;
        int[] arr = new int[number];
        boolean[] flag = new boolean[number];
        int[] p = new int[number];
        int index = 0;
        int k;
        for (int i = 2; i < number; i++) {
            if (!flag[i]) {
                p[index] = i;
                index++;
                for (int j = 2 * i; j < number; j = j + i) {
                    flag[j] = true;
                }
            }
        }
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                k = p[i] + p[j];
                if (k < number) {
                    arr[k]++;
                } else {
                    break;
                }
            }
        }
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int i = s.nextInt();
            System.out.println(arr[i]);
        }
        s.close();
    }

}
