package 笔试.jungel.vivo;

import com.alibaba.fastjson.JSON;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class First {

    private static class Area{
        int x;
        int y;
        int last_x;
        int last_y;
        int depth;

        @Override
        public String toString() {
            return "Area{" +
                    "x=" + x +
                    ", y=" + y +
                    ", last_x=" + last_x +
                    ", last_y=" + last_y +
                    ", depth=" + depth +
                    '}';
        }

        public Area(int x, int y, int last_x, int last_y, int depth) {
            this.x = x;
            this.y = y;
            this.last_x = last_x;
            this.last_y = last_y;
            this.depth = depth;

        }
    }
    private static int[][] dirt = {{-1,0},{0,1},{1,0},{0,-1}};

    private static boolean[][] isVisted;
    private static int size;
    private static char[][] mat;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        size = n;
        isVisted = new boolean[n][n];
        scanner.nextLine();

        int x_start = scanner.nextInt();
        int y_start = scanner.nextInt();
        int x_end = scanner.nextInt();
        int y_end = scanner.nextInt();

        scanner.nextLine();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j]=s.charAt(j);
            }
        }

        mat=grid;
        LinkedList<Area> queue = new LinkedList<>();

        Area start = new Area(x_start, x_end,x_start,x_end, 0);

        isVisted[x_start][x_end]=true;
        queue.add(start);

        int res = -1;
        while (queue.size()!=0) {
            Area area = queue.removeFirst();
            System.out.print(area);
            System.out.println("  "+mat[area.x][area.y]);
            if (area.x==y_start&&area.y==y_end) {
                res = area.depth;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = area.x+ dirt[i][0];
                int newY = area.y+ dirt[i][1];

                if (inArea(newX,newY)&&mat[newX][newY]!='#'&&mat[newX][newY]!='@'&&!isVisted[newX][newY]) {
                    isVisted[newX][newY]=true;
                    queue.addLast(new Area(newX,newY,area.x,area.y,area.depth+1));
                }
            }
        }


        System.out.println(res);
    }


    private static boolean inArea(int x,int y) {

        return x>=0&&x<size&&y>=0&&y<size;
    }
}
