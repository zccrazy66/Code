package 笔试.jungel;

import java.util.Arrays;
import java.util.Scanner;

public class QQ1 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        int first = scanner.nextInt();

        ListNode head = new ListNode(first);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < n; i++) {
            head.next = new ListNode(scanner.nextInt());
            head = head.next;
        }

        ListNode cur =dummy;

        for (int i = 0; i < k-1; i++) {
            cur = cur.next;
        }

        ListNode next = cur.next.next;
        cur.next = next;

        while (dummy.next!=null) {
            System.out.print(dummy.next.val);
            dummy=dummy.next;
            if (dummy!=null) System.out.print(" ");
        }

    }
}
