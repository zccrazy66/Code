package main.java.笔试.zczc.华为;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class huawei02 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int[] input = new int[N];
//        for (int i = 0; i < N; i++) {
//            input[i] = in.nextInt();
//        }
//        BigDecimal zh = C(5, 2);
        System.out.println(C(5,2));

//        System.out.println(solution(input));

    }

    public static int A(int n, int m) {
        int result = 1;
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--) {
            result *= n;
            n--;// 下一次减一
        }
        return result;
    }

    public static int C(int n, int m){
        // 应用组合数的互补率简化计算量
        m = m > (n - m) ? (n - m) : m;
        // 分子的排列数
        int son = A(n, m);
        // 分母的排列数
        int mother = A(m, m);
        return son / mother ;
    }




}
