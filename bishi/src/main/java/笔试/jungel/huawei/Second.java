package 笔试.jungel.huawei;

import com.alibaba.fastjson.JSON;

import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            String s = scanner.nextLine();

            for (int j = 0; j < N; j++) {

                grid[i][j] = s.charAt(j)=='S'?1:0;
            }
        }

        System.out.println(JSON.toJSONString(grid));
    }
}
