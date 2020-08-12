package meituan;

import java.util.Scanner;

public class shuru {

    private static void erweishuzu (){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] input = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                input[i][j] = in.nextInt();
            }
        }
    }




}
