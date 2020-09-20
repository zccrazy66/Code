package 笔试.jungel.sanliuling;

import java.util.Scanner;

public class TX01 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int[][] mat=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                mat[i][j]=s.nextInt();
            }
        }
        int[][] memo=new int[m+1][n+1];
        // 初始化

        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                for (int k=0;k<=j;k++){
                    if (k-1<0){
                        memo[i][j]=memo[i-1][j];
                    }
                    else {
                        memo[i][j]=Math.max(memo[i][j],memo[i-1][j-k]+mat[i-1][k-1]);
                    }
                }
            }
        }
        System.out.println(memo[m][n]);
    }
}
