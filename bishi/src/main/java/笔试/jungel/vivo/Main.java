package 笔试.jungel.vivo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    // 自己写吧

    public static void main(String[] args) {

        int[] arr ={1,1,2,3,3,3,4,4};
        System.out.println(Arrays.toString(get(arr)));
    }
    public static int[] get(int[] arr) {

        int n = arr.length;
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i-1]==arr[i]) {
                continue;
            }else {
                list.addLast(arr[i]);
            }
        }

        int size = list.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
