package 笔试.jungel.keda;

import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/8/29 19:36
 */
public class xf03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        StringBuffer res = new StringBuffer();

        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
//        System.out.println(res);
        //去除尾部下划线
        for (int i = n -1; i >= 0; i--) {
            if (res.charAt(i) == '_') res.deleteCharAt(i);
            else break;
        }
        //去除首部下划线
        while (res.length() > 0) {
            if (res.charAt(0) == '_') res.deleteCharAt(0);
            else break;
        }
//        System.out.println(res);

        while (res.length() > 0) {
            int flag = -1;
            int tmp = res.length();
            for (int i = 0; i < tmp-1; i++) {
//                System.out.println("进入for");
                if (res.charAt(i) == '_' && res.charAt(i+1) == '_') {
                    flag = i;
                    break;
                }
            }
            if (flag == -1) break;
            res.deleteCharAt(flag);
        }
        System.out.println(res);
    }
}
