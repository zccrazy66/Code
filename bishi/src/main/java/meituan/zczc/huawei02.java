package meituan.zczc;

import java.util.Arrays;
import java.util.Scanner;

public class huawei02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = in.nextInt();
        }

        System.out.println(solution(input));

    }

    private static int solution(int[] input){
        int length = input.length;
        if (length < 1) return 0;
        Arrays.sort(input);
        int mid = 1; // 中间值
        int res = 1; // 返回值
        int count = 0; // 中间计数，有几个？
        int zancun = 1;
        for (int i = 1; i < length; i++) {
            int temp = 0;
            if (input[i] != mid){
                temp = count;
                mid++;
            }else {
                count++;
            }
            res = res * (zancun * 2 - temp + 1);
        }
        return res;
    }



}
