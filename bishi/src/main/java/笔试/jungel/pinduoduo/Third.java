package 笔试.jungel.pinduoduo;

import java.util.Scanner;

public class Third {


    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[] weight = new int[n];
        int[] val =new int[n];
        for (int i=0;i<n;i++){
            weight[i]=s.nextInt();
            val[i]=s.nextInt();
        }


        int[] memo = new int[m+1];
        for(int i=0;i<memo.length;i++){
            memo[i] = 0;
        }
        for(int i=0;i<n;i++){
            for(int j=memo.length-1;j>=weight[i];j--){
                memo[j] = Math.max(memo[j], memo[j-weight[i]]+val[i]);
            }
        }
        System.out.println(memo[memo.length-1]);
    }
}
