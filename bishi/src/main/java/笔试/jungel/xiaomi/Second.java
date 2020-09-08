package 笔试.jungel.xiaomi;


import java.util.Scanner;

public class Second {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        if ("".equals(word)||word==null) {
            System.out.println(true);
            return;
        }

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        System.out.println(new Second().exist(board,word));
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private int[][] dirt = {{-1,0},{0,1},{1,0},{0,-1}};
    // 长
    private int m;
    // 宽
    private int n;
    // 矩阵
    private char[][] mat;
    // 要验证的字符串
    private String str;
    // 记忆化数组
    private boolean[][] isVisited;
    public boolean exist(char[][] board,String word) {
        m = board.length;
        n = board[0].length;
        mat = board;
        str = word;
        isVisited = new boolean[m][n];
        boolean isExisted = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(i,j,0)) isExisted=true;
            }
        }

        return isExisted;
    }

    private boolean dfs(int i, int j,int index) {
        isVisited[i][j]=true;

        if ((index==str.length()-1)&&mat[i][j]==(str.charAt(index))) return true;

        if (mat[i][j]!=(str.charAt(index))) return false;

        for (int k = 0; k < 4; k++) {
            int newX = i+dirt[k][0];
            int newY = j+dirt[k][1];

            if (inArea(newX,newY)&&!isVisited[newX][newY]&&dfs(newX,newY,index+1)) return true;
        }

        isVisited[i][j]=false;
        return false;
    }

    /**
     * 是否在矩阵内
     */
    private boolean inArea(int x,int y) {
        return x>=0&&x<m&&y>=0&&y<n;
    }
}
