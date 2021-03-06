package main.java.笔试.zczc.浪潮;

import java.util.*;

public class 被砍掉的树 {
    private static int[] oddArr;
    private static int[] evenArr;
    public static int[] getLongestTreeSequence(int[] arr, List<Integer> cutTreeList) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        Collections.sort(cutTreeList);
        int pos = -1;
        int longest = 0;
        int i = 0;
        while (!queue.isEmpty() && i < cutTreeList.size()) {
            int cutTreeVal = cutTreeList.get(i);
            int curLen = 0;
            int curPos = queue.peek();
            while (!queue.isEmpty() && queue.peek() < cutTreeVal) {
                queue.poll();
                curLen++;
            }
            if (!queue.isEmpty() && cutTreeVal == queue.peek()) {
                queue.poll();
            }
            if (curLen > longest) {
                pos = curPos;
                longest = curLen;
            }
            i++;
        }
        if (!queue.isEmpty()) {
            if (queue.size() > longest) {
                pos = queue.peek();
                longest = queue.size();
            }
        }
        int[] ret = new int[2];
        ret[0] = pos;
        ret[1] = longest;
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] oddArr = new int[50];
        oddArr[0] = 1;
        for (int i = 2; i <= 50; i++) {
            oddArr[i - 1] = 2 * i - 1;
        }
        int[] evenArr = new int[50];
        for (int j = 1; j <= 50; j++) {
            evenArr[j - 1] = j * 2;
        }
        while (in.hasNext()) {
            String input1 = in.nextLine();
            int N = Integer.parseInt(input1);
            String input2 = in.nextLine();
            String[] cutTrees = input2.split(" ");
            List<Integer> oddList = new ArrayList<>();
            List<Integer> evenList = new ArrayList<>();
            for (int j = 0; j < cutTrees.length; j++) {
                int temp = Integer.parseInt(cutTrees[j]);
                if ((temp & 1) == 0) {
                    evenList.add(temp);
                } else {
                    oddList.add(temp);
                }
            }
            int[] oddLongest = getLongestTreeSequence(oddArr, oddList);
            int[] evenLongedt = getLongestTreeSequence(evenArr, evenList);
            if (oddLongest[1] > evenLongedt[1]) {
                System.out.print(oddLongest[0] + " " + oddLongest[1]);
            } else if (oddLongest[1] < evenLongedt[1]) {
                System.out.print(evenLongedt[0] + " " + evenLongedt[1]);
            } else {
                if (evenLongedt[0] < oddLongest[0]) {
                    System.out.print(evenLongedt[0] + " " + evenLongedt[1]);

                } else {
                    System.out.print(oddLongest[0] + " " + oddLongest[1]);
                }
            }
        }
}


}
