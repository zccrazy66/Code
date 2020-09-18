package main.java.笔试.tx.京东;

import java.util.Scanner;

public class 试题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i =0;i<n;i++){
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int start_i = 0;
            int start_j = 0;
            Character[][] input = new Character[row][col];
            scanner.nextLine();
            for (int j = 0; j < input.length; j++) {
                String s = scanner.nextLine();
                for (int k = 0; k < s.length(); k++) {
                    input[j][k] = s.charAt(k);
                    if(s.charAt(k) == 'S'){
                        start_i = j;
                        start_j = k;
                    }
                }
            }
            res = false;
            find(input,new boolean[input.length][input[0].length],start_i,start_j);
            System.out.println(res?"YES":"NO");
        }
    }
    private static boolean res;
    private static void find(Character[][] ditu,boolean[][] visted,int i,int j){
        if(i<0||j<0||i>=ditu.length||j>=ditu.length||visted[i][j]){
            return;
        }
        if(ditu[i][j] == 'E'){
            res = true;
            return ;
        }
        visted[i][j] = true;
        if(ditu[i][j]!='#'){
            find(ditu,visted,i+1,j);
            find(ditu,visted,i,j+1);
            find(ditu,visted,i-1,j);
            find(ditu,visted,i,j-1);
        }
    }
}