package 笔试.tx;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            int val = scanner.nextInt();
            list.addLast(val);
        }

        // 初始数组
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= N; i++) {

            linkedList.addLast(i);
        }

        int size = linkedList.size();
        Main main = new Main();
        for (Integer integer : list) {
            if (integer==1) {
                linkedList= main.move(linkedList);

            }else {
                linkedList = main.swap(linkedList);
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(linkedList.removeFirst());
            if (linkedList.size()!=0) {
                System.out.print(" ");
            }
        }
    }

    /**
     * 交换操作
     */
    private LinkedList<Integer> swap(LinkedList<Integer> resList) {

        int num = resList.size();
        for (int i = 0; i < num-1; i=i+2) {
            Integer a = resList.get(i);
            Integer b = resList.get(i + 1);
            resList.set(i,b);
            resList.set(i+1,a);
        }


        return resList;
    }

    private int[] swap(int[] arr) {

        int num = arr.length;
        for (int i = 0; i < num-1; i=i+2) {
            Integer a = arr[i];
            Integer b = arr[i+1];
            arr[i]=b;
            arr[i+1] = a;
        }


        return arr;
    }


    /**
     * 移动操作
     */
    private LinkedList<Integer> move(LinkedList<Integer> resList) {
        Integer integer = resList.removeFirst();
        resList.addLast(integer);
        return resList;
    }
}
