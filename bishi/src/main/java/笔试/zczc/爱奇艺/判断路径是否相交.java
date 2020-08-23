package main.java.笔试.zczc.爱奇艺;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 判断路径是否相交 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        if (path == null || "".equals(path)){
            System.out.println("False");
            return;
        }
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (int i = 0; i < path.length(); i++) {
            char temp = path.charAt(i);
            int x_next = 0, y_next = 0;
            if (temp == 'N'){
                x_next = x;
                y_next = y + 1;
            }else if (temp == 'S'){
                x_next = x;
                y_next = y - 1;
            }else if (temp == 'E'){
                x_next = x + 1;
                y_next = y;
            }else if (temp == 'W'){
                x_next = x - 1;
                y_next = y;
            }

            if (set.contains(x_next + "," + y_next)){
                System.out.println("True");
                return;
            }else {
                set.add(x_next + "," + y_next);
                x = x_next;
                y = y_next;
            }

        }

        System.out.println("False");



    }




}
