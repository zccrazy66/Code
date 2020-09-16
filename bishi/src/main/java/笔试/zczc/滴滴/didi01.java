package main.java.笔试.zczc.滴滴;

import java.util.Arrays;
import java.util.Scanner;

public class didi01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] temp = a.split(" ");
        long[] input = new long[4];
        for (int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(temp[i]);
        }
        int flag = 0;
        if (judge(input)){
            System.out.println(input[0] * 4);
            return;
        }
        Arrays.sort(input);
        while (!judge(input) || input[3] > 2){
            if (input[0] + input[1] + input[2] + input[3] < 8){
                flag = 1;
                break;
            }
            input[0] = input[0] + 1;
            input[3] = input[3] - 2;
            Arrays.sort(input);
        }
        if (flag == 1){
            System.out.println("-1");
        }else {
            System.out.println(input[0] * 4);
        }
    }
    private static boolean judge(long[] input){
        return input[0] == input[1] && input[1] == input[2] && input[2] == input[3];
    }

}
