package 笔试.jungel.baidu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        isValid();
    }

    public static void isValid() {
        Scanner s = new Scanner(System.in);
        List<List<Integer>> res=new LinkedList<>();
        List<Integer> ressum=new LinkedList<>();
        int t = s.nextInt();
        if (t==0)return;
        for (int l=0;l<t;l++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] nums = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                int k = s.nextInt();
                for (int j = 0; j < k; j++) {
                    int a = s.nextInt();
                    int b = s.nextInt();
                    for (int c = a; c <= b; c++) {
                        nums[i][c] = 1;
                    }
                }
            }
            int sum = 0;
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                boolean is = true;
                for (int j = 0; j < m; j++) {
                    if (nums[j][i] == 0) {
                        is = false;
                        break;
                    }
                }
                if (is) {
                    sum++;
                    list.add(i);
                }
            }
            ressum.add(sum);
            res.add(list);
        }
        for (int l=0;l<t;l++){
            System.out.println(ressum.get(l));
            List<Integer> cur=res.get(l);
            for (int i = 0; i < cur.size(); i++) {
                System.out.print(cur.get(i) + " ");
            }
            System.out.println();
        }
    }
}
