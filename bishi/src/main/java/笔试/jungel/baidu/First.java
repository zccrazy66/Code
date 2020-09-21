package 笔试.jungel.baidu;

import java.util.Arrays;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr =new int[n];

        boolean flag = false;
        int num_5 = 0;
        int num_0 = 0;
        for (int i = 0; i < n; i++) {
            int nextInt = scanner.nextInt();
            if (nextInt==0) {
                flag = true;
                num_0++;
            }else {
                num_5++;
            }

            arr[i] = nextInt;
        }

        if (!flag) {
            System.out.println(-1);
            return;
        }
        // 依次组成最大的数

        int use_5 = num_5;
        int use_0 = num_0;

        int m = use_5 / 9;
        if (m<1) {
            System.out.println(0);
            return;
        }

        String str = "";

        for (int i = 0; i < m * 9; i++) {
            str =str+"5";
        }

        for (int i = 0; i < num_0; i++) {
            str = str+"0";
        }

        System.out.println(str);
    }


}
