package 笔试.jungel.vivo;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int n = s.length();

        String res = "";
        for (int i = 0; i < n; i++) {

            String newStr = s.substring(0,i)+s.substring(i+1);

            if (isHuiWen(newStr)) {
                res = newStr;
                break;
            }

        }

        if ("".equals(res)) {
            System.out.println(false);
        }else {
            System.out.println(res);
        }
    }

    private static boolean isHuiWen(String s) {

        int n = s.length();

        int l=0,r=n-1;

        while (l<r) {
            if (s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
