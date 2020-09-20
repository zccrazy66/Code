package main.java.笔试.joey.dianxin;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/16 20:57
 */
public class cloud02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        HashMap<Character, Integer> map = new HashMap();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1); //统计字符出现次数
        }

        int min_time = Integer.MAX_VALUE;

        StringBuffer tmp = new StringBuffer();

        for (char ch : map.keySet()) {
            if (map.get(ch) < min_time) {
                min_time = map.get(ch); //统计出现最小次数字符
            }
        }

        StringBuffer helper = new StringBuffer();

        for (char ch : s.toCharArray()) {
            if (map.get(ch) == min_time) helper.append(ch);  //统计需要删除的字符
        }

        for (char ch : s.toCharArray()) {
            int flag = 0;
            for (int i = 0; i < helper.length(); i++) {
                if(ch == helper.charAt(i)) {
                    flag += 1;
                    break;
                }
            }
            if (flag == 0) tmp.append(ch);
        }
        System.out.println(tmp.toString());
    }
}
