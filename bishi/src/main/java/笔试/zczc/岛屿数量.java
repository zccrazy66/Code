package main.java.笔试.zczc;

/**
 * @program: Question
 * @description
 * @author: zc
 * @create: 2020-07-07 16:26
 **/
public class 岛屿数量 {

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0'){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        int[] x = new int[]{0,1,0,-1};
        int[] y = new int[]{1,0,-1,0};

        if (i<0 || j <0 || i>= grid.length || j >= grid[0].length || grid[i][j] == '1'){
            return;
        }
        grid[i][j] = '1';
        for (int k = 0; k < 4; k++) {
            dfs(grid,x[k],y[k]);
        }
    }


}
