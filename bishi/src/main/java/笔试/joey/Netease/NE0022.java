package main.java.笔试.joey.Netease;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/12 16:05
 */
public class NE0022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            int time_a = 0, time_b = 0, time_c = 0,
                    time_x = 0, time_y = 0, time_z = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == 'a') time_a++;
                if (s.charAt(j) == 'b') time_b++;
                if (s.charAt(j) == 'c') time_c++;
                if (s.charAt(j) == 'x') time_x++;
                if (s.charAt(j) == 'y') time_y++;
                if (s.charAt(j) == 'z') time_z++;
                if (time_a % 2 == 0 && time_b % 2 == 0 && time_c % 2 == 0 &&
                time_x % 2 == 0 && time_y % 2 == 0 && time_z % 2 == 0) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        System.out.println(res);
    }
}
