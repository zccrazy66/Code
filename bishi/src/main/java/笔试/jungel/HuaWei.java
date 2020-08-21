package main.java.笔试.jungel;

import java.util.Scanner;

public class HuaWei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frame = scanner.nextLine();
        String brick = scanner.nextLine();
        int m = frame.length();
        int n = brick.length();
        int[] arr = new int[n];
        // 如果宽度相等，直接插入

        if (m==n) {

        }

        // 找到最新接触的列
        for (int i = 0; i < n; i++) {

            int value = Integer.parseInt("" + frame.charAt(i)) + Integer.parseInt("" + brick.charAt(i));


        }


    }
}
