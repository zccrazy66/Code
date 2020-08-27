package 笔试.jungel.jingdong;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Scanner;

public class Second {

    static LinkedList<Integer>[] mat;
    static int row;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer>[] list = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < (2 * i + 1); j++) {
                int anInt = scanner.nextInt();
                list[i].addLast(anInt);
            }

        }
        mat = list;
        row = n;
        int res = dfs(0,0);
        System.out.println(res);

    }

    private static int dfs(int x,int y) {

        if (x==row-1) return mat[x].get(y);

        int max = Math.max(dfs(x + 1, y), dfs(x + 1, y + 1));
        return Math.max(max,dfs(x+1,y+2))+mat[x].get(y);


    }
}
