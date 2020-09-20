package bishi.src.main.java.笔试.bin.DIdi;

import java.util.Scanner;

/**
 * Created by 林松斌的船 on 2020/8/21.
 */
public class DD000001 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String x = s.nextLine();
        String str = s.nextLine();
        StringBuffer res = new StringBuffer();
        int i = 0;
        for (; i < str.length(); i += n) {
            if (str.length() - i < n) break;
            for (int j = n - 1; j >= 0; j--) {
                res.append(str.charAt(i + j));
            }
        }
        for (int j = str.length() - 1; j >= i; j--) {
            // System.out.println(j);
            res.append(str.charAt(j));
        }
        // res.append(str);
        System.out.println(res);

    }
}
