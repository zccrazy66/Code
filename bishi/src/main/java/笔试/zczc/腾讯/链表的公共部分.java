package main.java.笔试.zczc.腾讯;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 链表的公共部分 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(in.nextInt(),1);
        }
        StringBuilder res = new StringBuilder();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int temp = in.nextInt();
            if (map.containsKey(temp)){
                res.append(temp);
                res.append(" ");
            }
        }
        System.out.println(res);
    }
}
