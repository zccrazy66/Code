package main.java.笔试.zczc.东方财富;

import java.util.Scanner;

public class 大树乘法 {

    public static void main(String[] args) {
        System.out.println(multiply("123","45"));

    }


    public static String multiply (String param1, String param2) {
        // write code here
        if (param1.equals("0") || param2.equals("0")){
            return "0";
        }
        int m = param1.length();
        int n = param2.length();
        int[] ansArr = new int[m + n];

        for (int i = m-1; i >=0 ; i--) {
            int x = param1.charAt(i) - '0';
            for (int j = n-1; j >=0; j--) {
                int y = param2.charAt(j) - '0';
                ansArr[i+j+1] += x*y;
            }
        }

        for (int i = m+n-1; i > 0; i--) {
            ansArr[i-1] += ansArr[i]/10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 :0;
        StringBuffer ans = new StringBuffer();
        while (index < m+ n){
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }




}
