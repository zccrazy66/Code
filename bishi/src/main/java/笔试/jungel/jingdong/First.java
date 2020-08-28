package 笔试.jungel.jingdong;

import java.util.Scanner;

public class First {

    static String[] num = {"2","3","5"};
    static int m = 1;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        arr = new int[1000+1];

        for (int i = 1; i < 10; i++) {

            if (m!=1001) dfs(0,i,"");
        }

        System.out.println(arr[n]);

    }

    private static void dfs(int index,int i,String str) {

        if (m==1001) {
            return;
        }
        if (index==i) {
            arr[m] = Integer.parseInt(str);
            m++;
            return;
        }
        for (int j = 0; j < 3; j++) {
            String s = num[j];

            dfs(index+1,i,str+s);
        }

    }
}
