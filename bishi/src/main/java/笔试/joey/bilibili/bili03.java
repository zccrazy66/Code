package main.java.笔试.joey.bilibili;

/**
 * @author JoeyChen
 * @data 2020/9/4 19:55
 */
public class bili03 {
    public static void main(String[] args) {
        String str = "aaabbaaac";
        int n = str.length();
        int time = 1;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i-1)!=str.charAt(i)) time++;
        }
        System.out.println(n / time);
    }
}
