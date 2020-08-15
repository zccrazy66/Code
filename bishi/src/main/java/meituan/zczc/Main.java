package meituan.zczc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 不一样的逆序数
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        List list = new Main().solution(input);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            List mid = (List) list.get(i);
            System.out.println(mid.get(0) + " " + mid.get(1));
        }
    }

    private List<List<Integer>> solution(int input){
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 1; i < input; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int target = nixu(i);
            if (i*4 == target){
                list.add(i);
                list.add(target);
                lists.add(list);
            }
        }
        return lists;

    }

    private int nixu(int i){
        StringBuffer temp = new StringBuffer();
        temp.append(i);
        return Integer.parseInt(String.valueOf(temp.reverse()));
    }
}
