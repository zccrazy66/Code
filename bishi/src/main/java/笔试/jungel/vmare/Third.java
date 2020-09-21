package 笔试.jungel.vmare;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Third {

    private static class Person {
        int x;
        int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int K = scanner.nextInt();

        int[] arr = new int[n+1];

        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            arr[p]++;
            arr[q]++;
            people[i]=new Person(p,q);
        }

        int resList =0;
        for (int i = 1; i < n; i++) {

            for (int j = i+1; j <= n; j++) {

                if (arr[i]+arr[j]>=K) {
                    int k_num=0;
                    for (int o = 0; o < n; o++) {

                        if (people[o].x==i||people[o].x==j||people[o].y==i||people[o].y==j) {
                            k_num++;
                        }

                    }
                    if (k_num>=K) {
                        resList++;
                    }
                }
            }

        }

        System.out.println(resList);
    }

}
