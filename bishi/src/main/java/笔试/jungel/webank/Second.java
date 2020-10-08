package 笔试.jungel.webank;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Scanner;

public class Second {
    private static class Mat{
        int x;
        int y;

        public Mat(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        scanner.nextLine();
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] grid=new int[m][n];
        // 初始化矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j]=i*n+j;
            }
        }
        // System.out.println(JSON.toJSONString(grid));
        // 对矩阵进行操作
        int a = x % 4;
        for (int i = 0; i < a; i++) {
            grid=shun(grid);
        }
        // System.out.println(JSON.toJSONString(grid));
        int b=y%2;
        for (int i = 0; i < b; i++) {
            grid=fanzhun(grid);
        }
        // System.out.println(JSON.toJSONString(grid));
        int c=z%4;
        for (int i = 0; i < c; i++) {
            grid=ni(grid);
        }
        System.out.println(JSON.toJSONString(grid));
        scanner.nextLine();
        int Q = scanner.nextInt();
        LinkedList<Mat> res =new LinkedList<>();
        for (int i = 0; i < Q; i++) {
            int p=scanner.nextInt();
            int q=scanner.nextInt();
            int curVal = (p - 1) * n + (q - 1);
            Mat mat = get(curVal, grid);
            res.addLast(mat);
        }

        for (Mat re : res) {
            System.out.print(re.x+1);
            System.out.print(" ");
            System.out.println(re.y+1);
        }
    }


    /**
     * 顺时针旋转90
     */
    public static int[][] shun(int[][] matrix){
        // 在建立新数组时将行和列的数量进行交换
        int[][] matrix2 = new
                int[matrix[0].length][matrix.length];
        // n为控制新数组列的输入的一个变量
        for(int i=0,n = matrix.length-1;i<matrix.length;i++,n--) {
            for(int j=0;j<matrix[0].length;j++) {
                //当i=0,j=0时,matrix2[0][matrix.length-1]在第一行最后一个元素的位置
                //当i=0,j=1时,matrix2[1][matrix.length-1]在第二行最后一个元素的位置
                //...依次往后推即可发现规律--原数组列的递增就是新数组最后一列行的递增
                matrix2[j][n] = matrix[i][j];
            }
        }
        return matrix2;
    }

    /**
     * 逆时针旋转90
     */
    public static int[][] ni(int[][] matrix){
        int[][] matrix2 = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0,n = matrix[0].length-1;j<matrix[0].length;j++,n--) {
                matrix2[n][i] = matrix[i][j];
            }
        }
        return matrix2;
    }

    /**
     * 水平盘转
     */
    public static int[][] fanzhun(int[][] matrix) {
        int tem=0,row_max = matrix.length-1;//rows 用来保存二维数组的行数最大值
        for(int i=0;i<matrix.length/2;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                tem = matrix[row_max-i][j];//（row_max - i）为倒数i行对应的行。
                matrix[row_max-i][j] = matrix[i][j];
                matrix[i][j] = tem;
            }
        }
        return matrix;
    }

    private static Mat get(int val,int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0;
        int j = 0;
        for (; i < m; i++) {
            for (; j < n; j++) {
                if (grid[i][j]==val) {
                    break;
                }
            }
        }

        return new Mat(i,j);
    }
}
