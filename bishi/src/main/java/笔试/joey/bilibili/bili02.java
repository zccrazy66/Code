package main.java.笔试.joey.bilibili;

/**
 * @author JoeyChen
 * @data 2020/9/4 19:28
 */
public class bili02 {
    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;

        int[] res = new int[row*col];
        int index = 0;

        int row_up = 0, row_bottom = row -1, col_left = 0, col_right = col -1;

        while (row_up <= row_bottom && col_left <= col_right) {
            for (int j = col_left; j <= col_right; j++) {
                res[index++] = matrix[row_up][j];
            }
            row_up++;
            for (int i = row_up; i <= row_bottom; i++) {
                res[index++] = matrix[i][col_right];
            }
            col_right--;

            if (row_up <= row_bottom && col_left <= col_right) {
                for (int j = col_right; j >= col_left; j--) {
                    res[index++] = matrix[row_bottom][j];
                }
                row_bottom--;
                for (int i = row_bottom; i >= row_up; i--) {
                    res[index++] = matrix[i][col_left];
                }
                col_left++;
            }
        }

        return res;
    }

}
