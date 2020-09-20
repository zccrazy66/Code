package main.java.笔试.tx;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author xin Tan
 * @create 2020-09-18 20:44
 */
public class 平安 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        if(max3(a, b + c, c) + max3(a, b, b + c)==0)
            System.out.println("ERROR");
        else {
            float res = help(a, b, c);
            System.out.println(res);
        }
    }

    public static int max2(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static int max3(int num1, int num2, int num3) {
        return max2(max2(num1, num2), num3);
    }

    public static float help(int a, int b, int c) {

        float res = max3(a + b, b, c) / (float)(max3(a, b + c, c) + max3(a, b, b + c));
        BigDecimal temp = new BigDecimal(res);
        float ans = temp.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
        return ans;
    }
}
