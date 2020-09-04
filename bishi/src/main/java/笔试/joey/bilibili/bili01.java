package main.java.笔试.joey.bilibili;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/4 19:33
 */
public class bili01 {
    public static void main(String[] args) {
        int k = 1;
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int n = arr.length;
        int start = 0;
        int res = 0;
        while (start < n) {
            int tmp = k;
            int tmp_res = 0;
            for (int i = start; i < n; i++) {
                if (arr[i] == 1) {
                    tmp_res++;
                    continue;
                } else {
                    if (tmp > 0) {
                        tmp_res++;
                        tmp--;
                    } else {
                        break;
                    }
                }
            }
            start++;
            tmp_res = tmp_res + tmp;
            res = Math.max(res, tmp_res);

        }
        System.out.println(res);

    }
}
