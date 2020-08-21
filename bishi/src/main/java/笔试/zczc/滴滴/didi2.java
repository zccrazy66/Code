package main.java.笔试.zczc.滴滴;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class didi2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set set = new HashSet();
        int start = n/2 -50;
        for (start = Math.max(start, 100) ; start <=(n + 100) && start < 1000   ; start++) {
            if (set.contains(start)) continue;
            int cha = n - start;
            if (cha < 100 || cha > 999){
                continue;
            }
            int a1 = start / 100;
            int a2 = cha / 100;
            if (a1 != a2)continue;
            int b1 = start%100/10;
            int b2 = cha%100/10;
            if (b1 == b2 || a1 == b1 || a1 ==b2)continue;
            int c1 = start % 10;
            int c2 = cha % 10;
            if (c1 == c2){
                continue;
            }
            if (a1 == c1 || a1 == c2) continue;
            if (b1 == c1 && b2 != c2) {
                set.add(cha);
            }

            if (b2 == c2 && b1 != c1) {
                set.add(start);
            }

            System.out.println(set.size());
            for (int i = 0; i < set.size(); i++) {
                System.out.println();
            }

        }


    }




}
