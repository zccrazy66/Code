package Code.bishi.src.main.java.笔试.bin;

import java.util.Arrays;
import java.util.*;

public class East {

    static int[][] res;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String A = s.nextLine();
        String B = s.nextLine();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        int[] aArray = new int[a.length];
        int[] bArray = new int[b.length];
        for (int i = 0; i < a.length; i++) {
            aArray[i] = Integer.parseInt(a[i]);
            bArray[i] = Integer.parseInt(b[i]);
        }
        int[] t = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            t[i] = bArray[i];
        }
        Arrays.sort(aArray);
        Arrays.sort(bArray);
        res = new int[2][a.length];
        help(aArray, bArray);
        for (int i = 0; i < a.length; i++) {
            int cur = t[i];
            for (int k = 0; k < a.length; k++) {
                if (res[1][k] == cur) {
                    res[1][k] = -1;
                    aArray[i] = res[0][k];
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(aArray[i] + " ");
        }
    }

    public static void help(int[] a, int[] b) {
        int win = 0;
        int k = 0;
        int i = 0, j = 0, x = a.length - 1, y = b.length - 1;
        while (i <= x) {
            if (a[x] > b[y]) {
                res[0][k] = a[x];
                res[1][k] = b[y];
                k++;
                x--;
                y--;

                win++;
            } else if (a[i] > b[j]) {
                res[0][k] = a[i];
                res[1][k] = b[i];
                k++;
                i++;
                j++;
                win++;
            } else {
                res[0][k] = a[i];
                res[1][k] = b[y];
                k++;
                i++;
                y--;

            }
        }
    }
}

