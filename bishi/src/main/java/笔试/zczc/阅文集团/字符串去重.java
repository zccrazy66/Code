package main.java.笔试.zczc.阅文集团;

import java.util.Scanner;

public class 字符串去重 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        System.out.println(removeRepeat(temp));
    }


    public static String removeRepeat(String str) {
        StringBuffer sb = new StringBuffer(str);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
        StringBuffer out = new StringBuffer(rs);
        return out.reverse().toString();
    }


}
