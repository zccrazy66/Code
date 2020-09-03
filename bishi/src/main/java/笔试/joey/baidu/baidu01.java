package main.java.笔试.joey.baidu;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/3 20:08
 */
public class baidu01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int zero = 0, five = 0;
        for (int i = 0; i < num; i++) {
            if (scanner.nextInt()==0) {
                zero++;
            } else five++;
        }
        if (zero == 0) {
            System.out.println(-1);
        } else if (five < 9) {
            System.out.println(0);
        } else {
            String five_basic_string = "555555555";
            StringBuffer res = new StringBuffer();
            for (int i = 0; i < five / 9; i++) {
                res.append(five_basic_string);
            }
            for (int i = 0; i < zero; i++) {
                res.append(0);
            }
            System.out.println(res);
        }
    }
}
