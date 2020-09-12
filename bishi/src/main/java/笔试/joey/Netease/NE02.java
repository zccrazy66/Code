package main.java.笔试.joey.Netease;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/12 15:32
 */
public class NE02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int time_a = 0, time_b = 0, time_c = 0,
                time_x = 0, time_y = 0, time_z = 0, time_others = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') time_a++;
            else if (s.charAt(i) == 'b') time_b++;
            else if (s.charAt(i) == 'c') time_c++;
            else if (s.charAt(i) == 'x') time_x++;
            else if (s.charAt(i) == 'y') time_y++;
            else if (s.charAt(i) == 'z') time_z++;
            else time_others++;
        }
        int res = time_others;
        if (time_a % 2 == 0) res += time_a;
        if (time_a % 2 == 1) res += time_a-1;

        if (time_b % 2 == 0) res += time_b;
        if (time_b % 2 == 1) res += time_b-1;

        if (time_c % 2 == 0) res += time_c;
        if (time_c % 2 == 1) res += time_c-1;

        if (time_x % 2 == 0) res += time_x;
        if (time_x % 2 == 1) res += time_x-1;

        if (time_y % 2 == 0) res += time_y;
        if (time_y % 2 == 1) res += time_y-1;

        if (time_z % 2 == 0) res += time_z;
        if (time_z % 2 == 1) res += time_z-1;
        System.out.println(res);
    }
}
