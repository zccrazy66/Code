package bishi.src.main.java.笔试.bin.Mi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/9/8.
 */
public class Mi01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] strings = str.split(" ");
        System.out.println(Arrays.toString(strings));
        for (int i = 0; i < strings.length; i++) {
            System.out.println(help(strings[i]));
        }
    }

    public static int help(String s) {
        if (s.length() < 8 || s.length() > 120) return 1;
        boolean hasint = false;
        boolean hasbig = false;
        boolean hassmall = false;
        boolean hasfuhao = false;
        for (int i = 0; i < s.length(); i++) {
            if (hasbig && hasfuhao && hasint && hassmall) break;
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                hasint = true;
            }
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                hassmall = true;
            }
            if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                hasbig = true;
            } else {
                hasfuhao = true;
            }
        }
        if (hasbig && hasfuhao && hasint && hassmall) return 0;
        else return 2;
    }

}
