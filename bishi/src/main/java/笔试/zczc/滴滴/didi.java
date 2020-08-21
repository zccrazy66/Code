package main.java.笔试.zczc.滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class didi {

    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        if (target < 200 || target > 2000){
            System.out.println("0");
        }
        int[] temp = new int[]{0,1,2,3,4,5,6,7,8,9};
        solution(target, temp);
        for (int i = 0; i < lists.size(); i++) {
            List list = lists.get(i);
            System.out.println(list.get(0) + " " + list.get(1));
        }
    }

    private static void solution(int target, int[] temp){
        for (int i = 1; i < temp.length; i++) {
            List<Integer> list = new ArrayList<>();
            int a = 100 * temp[i];
            if (a * 2 > target) return;
            for (int j = 0; j < temp.length; j++) {
                if (j == i) continue;
                int b = temp[j] * 10;
                if (a + b > target) return;
                for (int k = 0; k < temp.length; k++) {
                    if (k == i || k == j) continue;
                    if (2 * a + b + temp[k] * 10 > target) return;
                    int first = a + b + temp[k];
                    int second = a + temp[k] * 10 + temp[k];
                    if (first + second == target){
                        list.add(first);
                        list.add(second);
                        lists.add(list);
                    }
                }
            }
        }
    }
}
