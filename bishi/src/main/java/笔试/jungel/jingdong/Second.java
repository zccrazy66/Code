package 笔试.jungel.jingdong;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Scanner;

public class Second {

    static LinkedList<Integer>[] lists;
    static int q;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer>[] list = new LinkedList[n];
        for (int i=0; i<n; i++) {
            list[i] = new LinkedList<Integer>();
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<=2*i; j++) {
                int a = scanner.nextInt();
                list[i].addLast(a);
            }

        }
        lists = list;
        q=n;
        int res = help(0,0);
        System.out.println(res);
    }

    private static int help(int x,int y) {
        if (x==q-1) return lists[x].get(y);
        int res=Math.max(help(x + 1, y), help(x+1, y+1));
        return Math.max(res,help(x+1,y+2))+lists[x].get(y);
    }
}
