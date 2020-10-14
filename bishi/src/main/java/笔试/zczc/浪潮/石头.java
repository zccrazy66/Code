package main.java.笔试.zczc.浪潮;

import java.util.Scanner;

public class 石头 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int num = 1, max = 1;
            int tree = in.nextInt();
            if (tree <= 100000) {
                int[] c = new int[tree];
                int[] cc = new int[tree];
                for (int i = 0; i < tree; i++) {
                    c[i] = in.nextInt();
                }
                if (tree < c.length)
                    System.out.println(0);
                for (int i = 0; i < tree; i++) {
                    cc[i] = c[i];
                    for (int j = i + 1; j < tree; j++) {
                        cc[j] = c[j];
                        if (cc[i] + 1 == cc[j]) {
                            num += 1;
                            cc[i] = cc[j];
                        }
                    }
                    if (num > max) {
                        max = num;
                    }
                    num = 1;
                }
                System.out.println(tree - max);
            }
        }
}
