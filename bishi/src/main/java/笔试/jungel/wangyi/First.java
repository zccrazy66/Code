package 笔试.jungel.wangyi;

import java.util.LinkedList;
import java.util.Scanner;

public class First {
    static int[][] dirt ={{0,1},{1,0},{0,-1},{-1,0}};
    static int[][] mat;
    static boolean[][] isVisited;
    private static int N;
    static int num;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        // C组数据
        int C = scanner.nextInt();
        for (int i = 0; i < C; i++) {
            N = scanner.nextInt();
            mat=new int[N][N];
            isVisited=new boolean[N][N];
            num=1;
            int M = scanner.nextInt();
            dfs(0,0,0,1);
            for (int j = 0; j < M; j++) {
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                list.addLast(mat[x][y]);
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 填充矩阵
     */
    private static void dfs(int x,int y,int x_inc,int y_inc) {
        mat[x][y]=num;
        num++;
        isVisited[x][y]=true;
        if(inArea(x+x_inc,y+y_inc)&&!isVisited[x+x_inc][y+y_inc]){
            dfs(x+x_inc,y+y_inc,x_inc,y_inc);
        }else{
            for(int i=0;i<4;i++) {
                int newX=x+dirt[i][0];
                int newY=y+dirt[i][1];
                if(inArea(newX,newY)&&!isVisited[newX][newY]) dfs(newX,newY,dirt[i][0],dirt[i][1]);
            }
        }
    }
    private static boolean inArea(int x,int y) {
        return x>=0&&x<N&&y>=0&&y<N;
    }
}
