package bishi.src.main.java.笔试.bin.BaiDu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 1
 * 10 2
 * 3
 * 1 2
 * 4 5
 * 8 8
 * 2
 * 1 4
 * 6 8
 * 4
 * 1 2 4 8
 * Created by 林松斌的船 on 2020/9/3.
 */
public class BaiDu02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ressum = new LinkedList<>();
        int t = s.nextInt();
        if (t == 0) return;
        //有t组
        for (int l = 0; l < t; l++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] nums = new int[m][n + 1];
            // System.out.println("m="+m+"n="+n+"t="+t);
            //检查每组特性放入二维数组
            for (int i = 0; i < m; i++) {
                int k = s.nextInt();
                // System.out.println(k);
                for (int j = 0; j < k; j++) {
                    int a = s.nextInt();
                    int b = s.nextInt();
                    for (int c = a; c <= b; c++) {
                        //System.out.println(c);
                        nums[i][c] = 1;
                        // System.out.println("i="+i+"c="+c);
                    }
                }
            }
            int sum = 0;
            List<Integer> list = new LinkedList<>();
            //对于每只牛从上往下每个特性都是1说明是符合要求的
            for (int i = 1; i <= n; i++) {
                boolean is = true;
                for (int j = 0; j < m; j++) {
                    if (nums[j][i] == 0) {
                        is = false;
                        break;
                    }
                }
                if (is == true) {
                    sum++;
                    list.add(i);
                }
            }
            ressum.add(sum);
            res.add(list);
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i) + " ");
//            }

        }
        for (int l = 0; l < t; l++) {
            System.out.println(ressum.get(l));
            // System.out.println("qwe");
            List<Integer> cur = res.get(l);
            for (int i = 0; i < cur.size(); i++) {
                System.out.print(cur.get(i) + " ");

            }
            System.out.println();
        }
    }
}
