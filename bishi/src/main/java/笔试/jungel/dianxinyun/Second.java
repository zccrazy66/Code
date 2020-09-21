package 笔试.jungel.dianxinyun;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(get(s));

    }

    private static String get(String s) {

        int[] arr =new int[26];

        int n = s.length();

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (arr[i]!=0) {
                res = Math.min(res,arr[i]);
            }
        }

        char[] chars = s.toCharArray();

        String str ="";
        for (int i = 0; i < n; i++) {

            if (arr[chars[i]-'a']!=res) {
                str=str+ chars[i];
            }
        }
        return str;
    }
}
