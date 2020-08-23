package 笔试.jungel;

import java.util.LinkedList;
import java.util.Scanner;

public class QQ2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();


        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if (i!=k-1) {
                list.addLast(temp);
            }
        }

        while (list.size()!=0) {
            System.out.print(list.removeFirst());
            if (list.size()!=0) System.out.print(" ");
        }
    }
}
