package main.java.笔试.zczc.阅文集团;

import java.util.Scanner;

public class 第二题 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] temp = input.split(",");
            int m = Integer.parseInt(temp[0]);
            int p = Integer.parseInt(temp[1]);
            int n = Integer.parseInt(temp[2]);

            int[][] a = new int[m][p];
            int[][] b = new int[p][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < p; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = scanner.nextInt();
                }
            }
            printMatrix(a,b);
        }

        private static void printMatrix(int[][] a,int[][] b){
            int c[][] = new int[a.length][b[0].length];
            int x,i,j;
            for(i = 0;i<a.length ;i++)
            {
                for(j = 0;j<b[0].length;j++)
                {
                    int temp = 0;
                    for(x = 0;x<b.length;x++)
                    {
                        temp+=a[i][x]*b[x][j];

                    }
                    c[i][j] = temp;
                }
            }
            for(int m = 0;m<a.length;m++)
            {
                for(int n = 0;n<b[0].length;n++)
                {
                    System.out.print(c[m][n]+"\t");
                }
                System.out.println();
            }
        }
}
