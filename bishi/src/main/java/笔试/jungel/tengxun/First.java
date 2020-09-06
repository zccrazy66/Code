package 笔试.jungel.tengxun;

import java.util.*;

public class First {


    private static LinkedList<LinkedList<Integer>> sets;
    private static boolean[] isVisted;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        isVisted = new boolean[m];
        LinkedList<LinkedList<Integer>> people = new LinkedList<>();

        int index_0 = -1;
        for (int i = 0; i < m; i++) {

            int k= scanner.nextInt();

            LinkedList<Integer> temp = new LinkedList<>();
            people.addLast(temp);
            for (int j = 0; j < k; j++) {
                int p = scanner.nextInt();
                if (p==0) index_0=i;
                people.get(i).addLast(p);
            }
        }

        if (index_0==-1) {
            System.out.println(1);
            return;
        }
        sets = people;
        dfs(index_0);

        for (int i = 0; i < m; i++) {
            if (isVisted[i]) {
                for (Integer person : people.get(i)) {
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
        for (Integer integer : sets.get(index)) {

            List<Integer> nears = getNear(integer);

            for (Integer near : nears) {
                dfs(near);
            }
        }
    }


    private static List<Integer> getNear(int val) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < sets.size(); i++) {
            if (!isVisted[i]&&sets.get(i).contains(val)) {
                list.add(i);
            }
        }
        return list;
    }
}
