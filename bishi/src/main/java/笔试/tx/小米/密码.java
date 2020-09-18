package main.java.笔试.tx.小米;

import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-08 18:59
 */
public class 密码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            System.out.println(help(str));
        }
    }

    public static int help(String str) {
        int len = str.length();

        int temp = 0;
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
        if (len < 8 || len > 120) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            int num = str.charAt(i);
            ///System.out.println(num);
            if (!flag1) {
                if (num >= 48 && num <= 57){
                    flag1 = true;
                    temp++;
                }
            }
            if (!flag2) {
                if (num >= 65 && num <= 90){
                    flag2 = true;
                    temp++;
                }
            }
            if (!flag3) {
                if (num >= 97 && num <= 122){
                    flag3 = true;
                    temp++;
                }
            }
            if (!flag4) {
                if (num >= 27 && num <= 47||num >= 123 && num <= 126){
                    flag4 = true;
                    temp++;
                }
            }

            if(temp==4){
                return 0;
            }
        }
        return 2;
    }
}
