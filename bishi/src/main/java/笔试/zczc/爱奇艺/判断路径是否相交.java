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
            char k = path.charAt(i);
            int newX = 0, newY = 0;
            if (k == 'N'){
                newX = x;
                newY = y + 1;
            }else if (k == 'S'){
                newX = x;
                newY = y - 1;
            }else if (k == 'E'){
                newX = x + 1;
                newY = y;
            }else if (k == 'W'){
                newX = x - 1;
                newY = y;
            }

            if (set.contains(newX + "," + newY)){
                System.out.println("True");
                return;
            }else {
                set.add(newX + "," + newY);
                x = newX;
                y = newY;
            }
        }
        System.out.println("False");

    }

}
