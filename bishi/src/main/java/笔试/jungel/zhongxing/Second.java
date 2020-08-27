package 笔试.jungel.zhongxing;

import com.alibaba.fastjson.JSON;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] =scanner.nextLine();
        }

        int res =0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (isValid(str[i],str[j],str[k])) res++;
                }
            }
        }
        System.out.println(res);
    }

    private static boolean isValid(String x, String y, String z) {

        for (int i = 0; i < 3; i++) {

            if ((x.charAt(i)==y.charAt(i)&&y.charAt(i)==z.charAt(i))||(x.charAt(i)!=y.charAt(i)&&y.charAt(i)!=z.charAt(i)&&x.charAt(i)!=z.charAt(i))) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
