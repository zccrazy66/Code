package meituan.jungel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 编程协议
 */
public class ByteDance02 {
    public int removeNum(String string) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 第一步,遍历找出0010的位置
        int n = string.length();
        if (n<4) return 0;
        for (int i = 0; i <= n-4; i++) {

            String substring = string.substring(i, i + 4);
            if (isValid(substring)) {
                map.put(i,1);
            }
        }
         return map.size();
    }

    /**
     * 判断四个字符是不是“0010”
     */
    private boolean isValid(String string) {
        return "0010".equals(string);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        LinkedList<Integer> strings = new LinkedList<>();

        ByteDance02 byteDance02 = new ByteDance02();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            int num = byteDance02.removeNum(s);
            strings.addLast(num);
        }

        for (Integer string : strings) {
            System.out.println(string);
        }
    }
}
