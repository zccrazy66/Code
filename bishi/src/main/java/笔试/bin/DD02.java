package bishi.src.main.java.笔试.bin;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛群岛
 * Created by 林松斌的船 on 2020/8/21.
 */
public class DD02 {
    public static void main(String[] args) {
        List<Integer> res=new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int C = s.nextInt();
        for (int k=0;k<C;k++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[] qwe = new int[n * n];
            if (n == 0) {
                System.out.println(" ");
            }

            int[][]  asd = new int[n][n];
            if (n > 0) {

                for (int i = 0; i < n * n; i++) {
                    qwe[i] = i + 1;
                }
                int high = 0, low = n - 1, left = 0, right = n - 1;
                int index = 0;
                while (index < n * n) {
                    for (int j = left; j <= right; j++) {
                        asd[high][j] = qwe[index];
                        index++;

                    }
                    high++;
                    for (int j = high; j <= low; j++) {
                        asd[j][right] = qwe[index];
                        index++;

                    }
                    right--;
                    for (int j = right; j >= left; j--) {
                        asd[low][j] = qwe[index];
                        index++;

                    }
                    low--;
                    for (int j = low; j >= high; j--) {
                        asd[j][left] = qwe[index];
                        index++;

                    }
                    left++;
                    /////////
                    for (int j = high; j <= low; j++) {
                        asd[j][left] = qwe[index];
                        index++;

                    }
                    left++;
                    for (int j = left; j <= right; j++) {
                        asd[low][j] = qwe[index];
                        index++;

                    }
                    low--;
                    for (int j = low; j >= high; j--) {
                        asd[j][right] = qwe[index];
                        index++;

                    }
                    right--;
                    for (int j = right; j >= left; j--) {
                        asd[high][j] = qwe[index];
                        index++;

                    }
                    high++;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                       // System.out.print(asd[i][j] + " ");
                    }
                   // System.out.println();
                }

            }
            for (int z=0;z<m;z++){
                int p=s.nextInt();
                int q=s.nextInt();
                res.add(asd[p][q]);
               // System.out.println(asd[p][q]);
            }
        }
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
