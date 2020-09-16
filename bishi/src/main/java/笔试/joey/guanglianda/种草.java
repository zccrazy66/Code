package main.java.笔试.joey.guanglianda;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author JoeyChen
 * @data 2020/9/16 19:03
 */
public class 种草 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int m_h = scanner.nextInt();
        //最小堆
        int[] arr = new int[n];
        Queue<Integer> queue = new PriorityQueue<>();  //最小堆
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        while (m > 0) {
            queue.add(queue.poll()+m_h);
            m--;
        }

        System.out.println(queue.peek());

    }
}
