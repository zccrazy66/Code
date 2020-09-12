package main.java.笔试.joey.Netease;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/12 15:56
 */
public class NE0002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long n = s.length();
        long time_a = 0, time_b = 0, time_c = 0,
                time_x = 0, time_y = 0, time_z = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') time_a++;
            if (s.charAt(i) == 'b') time_b++;
            if (s.charAt(i) == 'c') time_c++;
            if (s.charAt(i) == 'x') time_x++;
            if (s.charAt(i) == 'y') time_y++;
            if (s.charAt(i) == 'z') time_z++;
        }
        if (time_a % 2 == 1) n--;
        if (time_b % 2 == 1) n--;
        if (time_c % 2 == 1) n--;
        if (time_x % 2 == 1) n--;
        if (time_y % 2 == 1) n--;
        if (time_z % 2 == 1) n--;
        System.out.println(n);
    }
}
