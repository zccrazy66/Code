package main.java.笔试.zczc.小米;

import java.util.Scanner;

public class 单词搜索 {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        char[][] input =new char[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                input[i][j]=s.next().charAt(0);
            }
        }
        String target = s.next();
        System.out.println(exist(input, target));
    }


    public static boolean exist(char[][] input, String target){
        int row = input.length;
        int col = input[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                if (find(input, target,flag, i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find(char[][] input, String target, boolean[][] flag, int i, int j , int index){
        int row = input.length;
        int col = input[0].length;
        if (target.length() == index){
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col){
            return false;
        }
        if (flag[i][j] || target.charAt(index)!=input[i][j]){
            return false;
        }
        flag[i][j] = true;
        boolean judge = find(input, target, flag,i-1,j,index + 1) ||
                        find(input, target, flag,i,j + 1,index + 1) ||
                        find(input, target, flag,i+1,j,index + 1) ||
                        find(input, target, flag,i,j -1,index + 1);
        return judge;
    }
}
