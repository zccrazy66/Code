package Code.bishi.src.main.java.meituan.bin;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/21.
 */
public class DD02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] qwe = new long[n * n];
        if (n==0){
            System.out.println(" ");
        }
        if (n==1){
            System.out.println(1);
        }
        if (n==2){
            System.out.println(3+" "+2);
            System.out.println(1+" "+1);
        }
        if (n >2) {
            qwe[0] = 1;
            qwe[1] = 1;
            long[][] asd = new long[n][n];
            for (int i = 2; i < n * n; i++) {
                qwe[i] = qwe[i - 1] + qwe[i - 2];
            }
            int high = 0, low = n - 1, left = 0, right = n - 1;
            int index = n * n - 1;
            while (index >= 0) {
                for (int j = left; j <= right; j++) {
                    asd[high][j] = qwe[index];
                    index--;

                }
                high++;
                for (int j = high; j <= low; j++) {
                    asd[j][right] = qwe[index];
                    index--;

                }
                right--;
                for (int j = right; j >= left; j--) {
                    asd[low][j] = qwe[index];
                    index--;

                }
                low--;
                for (int j = low; j >= high; j--) {
                    asd[j][left] = qwe[index];
                    index--;

                }
                left++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(asd[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
