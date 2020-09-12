package main.java.笔试.zczc.网易;

import java.util.Scanner;

public class Main {
    static int min = Integer.MIN_VALUE;
    static int[][] temp ={{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start_x = in.nextInt();
        int start_y = in.nextInt();
        int end_x = in.nextInt();
        int end_y = in.nextInt();

        String[][] input = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = in.nextLine();
            }
        }

        int[][] squera = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j].equals("#") || input[i][j].equals("@")){
                    squera[i][j] = 1;
                }else {
                    squera[i][j] = 0;
                }
            }
        }

        int[][] visited = new int[n][n];
        visited[start_x][start_y] = 1;
        dfs(start_x, start_y, 0, end_x, end_y, squera, visited);
        System.out.println(min);
    }
    private static void dfs(int x, int y, int step, int end_x, int end_y, int[][] squera, int[][] visited){
        if (x == end_x && y == end_y){
            if (step < min){
                min = step;
            }
            return;
        }
        int n = squera.length;
        for(int i=0 ; i<4; i++){
            int tx = temp[i][0];
            int ty = temp[i][1];
            if(x + tx<0 || x+tx>=n)
                continue;
            if(y + ty<0||y + ty>=n)
                continue;
            if(squera[x+tx][y+ty]==0 && visited[x+tx][y+ty]==0){
                visited[x+tx][y+ty] = 1;
                dfs(x+tx,y+ty,step+1, end_x,end_y,squera,visited);
                visited[x+tx][y+ty] = 0;
            }
        }
    }
}
