package 笔试.jungel.tengxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class First {


    private static TreeSet<Integer>[] sets;
    private static boolean[] isVisted;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        isVisted = new boolean[m];
        TreeSet<Integer>[] people = new TreeSet[m];

        int index_0 = -1;
        for (int i = 0; i < m; i++) {

            int k= scanner.nextInt();

            people[i]=new TreeSet<>();
            for (int j = 0; j < k; j++) {
                int p = scanner.nextInt();
                if (p==0) index_0=i;
                people[i].add(p);

            }
        }

//        if (index_0==-1) {
//            System.out.println(1);
//            return;
//        }
        sets = people;
        dfs(index_0);

        for (int i = 0; i < m; i++) {
            if (isVisted[i]) {
                for (Integer person : people[i]) {
                    arr[person]++;
                }
            }
        }


        int res=0;
        for (int i : arr) {
            if (i!=0) res++;
        }

        System.out.println(res);
    }

    private static void dfs(int index) {

        isVisted[index]=true;
        for (Integer integer : sets[index]) {

            List<Integer> nears = getNear(integer);

            for (Integer near : nears) {
                dfs(near);
            }
        }
    }


    private static List<Integer> getNear(int val) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < sets.length; i++) {
            if (!isVisted[i]&&sets[i].contains(val)) {
                list.add(i);
            }
        }
        return list;
    }
}
