package 笔试.jungel.didi;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Second {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 组数
        int T = scanner.nextInt();
        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            TreeSet<Integer>[] list=new TreeSet[n];
            for (int p = 0; p < n; p++) {
                list[p]=new TreeSet<>();
            }

            int num = 0;
            for (int j = 0; j < m; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                if (c<=k) {
                    num++;
                    list[a-1].add(b-1);
                    list[b-1].add(a-1);
                }
            }
            if (num<n-1) {
                res.addLast("No");
            }else {

                if (dfs(n,list)) {
                    res.addLast("Yes");
                }else {
                    res.addLast("No");
                }
            }
        }

        for (String re : res) {
            System.out.println(re);
        }
    }

    static boolean[] arr;
    static TreeSet<Integer>[] set;
    private static boolean dfs(int n, TreeSet<Integer>[] list) {

        arr = new boolean[n];
        set = list;
        arr[0]=true;
        help(0);


        for (int i = 1; i < n; i++) {
            if (!arr[i]) return false;
        }

        return true;
    }

    private static void help(int index) {
        for (Integer integer : set[index]) {
            if (!arr[integer]) {
                arr[integer]=true;
                help(integer);
            }

        }
    }
}
