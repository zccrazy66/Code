package main.java.笔试.zczc.爱奇艺;

import java.util.Scanner;

public class n的阶乘问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(CountZero(input));
    }


    private static int CountZero(int input){
        int temp = 0;
        if (input < 5){
            return 0;
        }

        for (int i = 5; i <= input; i++) {
            int num = i;
            while ((num % 5 == 0) && (num >= 5)){
                num = num /5 ;
                temp++;
            }
        }

        return temp;

    }



}
