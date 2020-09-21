package 笔试.jungel.pinduoduo;

import com.alibaba.fastjson.JSON;

import java.util.Scanner;

public class Forth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[M];

        boolean flag =false;
        for (int i = 0; i < M; i++) {
            int anInt = scanner.nextInt();
            if (anInt==2) flag=true;
            arr[i] = anInt;
        }




        int num = 0;
        for (int i = 1; i <= N; i++) {

            if (flag&&i%2==0) {
                num++;
                continue;
            }
            for (int t : arr) {

                if (i%t==0) {
                    num++;
                    break;
                }
            }
        }
        System.out.println(num);
    }
}
