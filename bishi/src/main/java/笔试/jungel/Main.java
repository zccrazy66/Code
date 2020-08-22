package 笔试.jungel;

import java.util.*;



public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            list.add(s);
        }

        int res = 0;
        Main main = new Main();
        for (String s : list) {
            if (main.isValid(s)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private boolean isValid(String str) {

        int length = str.length();
        if (length>10||length<1) return false;

        for (int i = 0; i < length; i++) {
            if (!isEnglish(str.charAt(i))) {

                return false;
            }
        }

        return true;
    }

    private boolean isEnglish(char c) {

        int a = c - 'A';
        int b = c - 'a';

        if ((a>=0&&a<=25)||(b>=0&&b<=25)) return true;
        return false;

    }
}
