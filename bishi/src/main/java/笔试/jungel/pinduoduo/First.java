package 笔试.jungel.pinduoduo;


import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] inner = new int[n][n];

        for (int i = 0; i < n / 2; i++) {
            for (int j = (n / 2); j < n-i-1; j++) {
                inner[i][j] = 1;
            }
        }

        for (int i = 0; i < (n / 2); i++) {
            for (int j = i+1; j < n / 2; j++) {
                inner[i][j] = 2;
            }
        }

        for (int i = 1; i < n / 2; i++) {
            for (int j = 0; j < i; j++) {
                inner[i][j] = 3;
            }
        }

        for (int i = (n / 2); i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                inner[i][j] = 4;
            }
        }

        for (int i = (n / 2)+1; i < n; i++) {
            for (int j = n-i-1+1; j < n/2; j++) {
                inner[i][j] = 5;
            }
        }

        for (int i = (n / 2)+1; i < n; i++) {
            for (int j = (n/2); j < i; j++) {
                inner[i][j] = 6;
            }
        }

        for (int i = (n / 2); i < n; i++) {
            for (int j = i+1; j < n; j++) {
                inner[i][j] = 7;
            }
        }

        for (int i = 1; i < n / 2; i++) {
            for (int j = (n-i-1+1); j < n; j++) {
                inner[i][j] = 8;
            }
        }

        if (n%2==1) {
            for (int i = 0; i < n; i++) {
                inner[n/2][i]=0;
                inner[i][n/2]=0;
            }

            for (int i = 0; i < n; i++) {
                inner[i][i]=0;
                inner[i][i]=0;
            }

            for (int i = 0; i < n; i++) {
                inner[i][n-i-1]=0;
            }
        }

        for (int i = 0; i < n; i++) {

            for (int o : inner[i]) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }
}
